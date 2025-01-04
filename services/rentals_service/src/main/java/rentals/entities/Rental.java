package rentals.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Rentals")
public class Rental {
    private String id;
    private int userId;
    private int bikeId;
    private long rentedOn;

    public Rental( int userId, int bikeId, long rentedOn) {
        this.userId = userId;
        this.bikeId = bikeId;
        this.rentedOn = rentedOn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public long getRentedOn() {
        return rentedOn;
    }

    public void setRentedOn(long rentedOn) {
        this.rentedOn = rentedOn;
    }
}
