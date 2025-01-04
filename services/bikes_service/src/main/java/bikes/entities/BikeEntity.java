package bikes.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity(name="Bike")
@Table(name="bikes", schema = "bikes")
@Data
public class BikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="station_id")
    private String stationId;

    @Column(name="rating")
    private Double rating;

    @Column(name="times_rated")
    private int timesRated;

    @Column(name="times_rented")
    private int timesRented;

    @Column(name="total_time_rented")
    private long totalTimeRented;
}
