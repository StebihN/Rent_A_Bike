package stations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import stations.mq.BikeMessage;
import stations.mq.Producer;
import stations.entities.Station;
import stations.repositories.StationRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    StationRepository stationRepository;

    @Autowired
    Producer producer;

    @GetMapping("/get/all")
    public @ResponseBody List<Station> getAll() {
        return stationRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public @ResponseBody Station getById(@PathVariable("id") String id){
        Optional<Station> station = stationRepository.findById(id);
        if(station.isPresent()){
            return station.get();
        }else {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public Station createStation(@RequestBody Station station){
        return stationRepository.insert(station);
    }

    @PutMapping("/update")
    public Station updateStation(@RequestBody Station station){
        if(stationRepository.existsById(station.getId())) {
            return stationRepository.save(station);
        } else{
            throw new ResponseStatusException(NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") String id){
        if(stationRepository.existsById(id)){
            stationRepository.deleteById(id);
        } else{
            throw new ResponseStatusException(NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/all")
    public void deleteAll(){
        stationRepository.deleteAll();
    }

    @PostMapping("/add")
    public BikeMessage addBike(@RequestBody BikeMessage message){
        Station station = getById(message.getLocationId());
        if(station.getBikeCount() < station.getSlotCount()){
            station.setBikeCount(station.getBikeCount() + 1);
            updateStation(station);
            producer.sendMessage(message);

            return message;
        } else {
            throw new ResponseStatusException(CONFLICT);
        }
    }

    @PostMapping("/remove")
    public BikeMessage removeBike(@RequestBody BikeMessage message){
        Station station = getById(message.getLocationId());
        if(station.getBikeCount() > 0){
            station.setBikeCount(station.getBikeCount() - 1);
            updateStation(station);
            message.setLocationId("out");
            producer.sendMessage(message);

            return message;
        } else{
            throw new ResponseStatusException(CONFLICT);
        }
    }
}
