package stations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import stations.entities.Station;
import stations.repositories.StationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    StationRepository stationRepository;

    @GetMapping("/get/all")
    public @ResponseBody List<Station> getAll() {
        return stationRepository.findAll();
    }

    @GetMapping("/get/free")
    public @ResponseBody List<Station> getFree(){
        List<Station> stations = stationRepository.findAll();
        return stations.stream().filter(station -> (station.getSlotCount() - station.getBikeCount()) > 0).collect(Collectors.toList());
    }

    @GetMapping("/get/{id}")
    public @ResponseBody Station getById(@PathVariable("id") String id) {
        Optional<Station> station = stationRepository.findById(id);
        if (station.isPresent()) {
            return station.get();
        } else {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public Station createStation(@RequestBody Station station) {
        return stationRepository.insert(station);
    }

    @PutMapping("/update")
    public Station updateStation(@RequestBody Station station) {
        Optional<Station> optionalStation = stationRepository.findById(station.getId());
        if (optionalStation.isPresent()) {
            if (optionalStation.get().getBikeCount() == 0) {
                return stationRepository.save(station);
            } else {
                throw new ResponseStatusException(CONFLICT);
            }
        }else {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") String id) {
        Optional<Station> station = stationRepository.findById(id);
        if (station.isPresent()) {
            if (station.get().getBikeCount() == 0) {
                stationRepository.deleteById(id);
            } else {
                throw new ResponseStatusException(CONFLICT);
            }
        } else {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        stationRepository.deleteAll();
    }

    @PatchMapping("/return/{id}")
    public void returnBike(@PathVariable("id") String id) {
        Optional<Station> optionalStation = stationRepository.findById(id);
        if (optionalStation.isPresent()) {
            Station station = optionalStation.get();
            if (station.getBikeCount() < station.getSlotCount()) {
                station.setBikeCount(station.getBikeCount() + 1);
                stationRepository.save(station);
            } else {
                throw new ResponseStatusException(CONFLICT);
            }
        } else {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }

    @PatchMapping("/rent/{id}")
    public void rentBike(@PathVariable("id") String id) {
        Optional<Station> optionalStation = stationRepository.findById(id);
        if (optionalStation.isPresent()) {
            Station station = optionalStation.get();
            if (station.getBikeCount() > 0) {
                station.setBikeCount(station.getBikeCount() - 1);
                stationRepository.save(station);
            } else {
                throw new ResponseStatusException(CONFLICT);
            }
        } else {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }
}
