package bikes.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity(name="Bike")
@Table(name="bike", schema = "bike")
@Data
public class BikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="bike_name")
    private String name;

    @Column(name="location_id")
    private String locationId;

    @Column(name="time_travelled")
    private Double timeTravelled;

    @Column(name="rent_count")
    private int rentCount;

    @Column(name="rating")
    private Double rating;

    @Column(name="rate_count")
    private int rateCount;

}
