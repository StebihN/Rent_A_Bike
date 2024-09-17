package stations.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Stations")
public class Station {

    private String id;
    private String city;
    private String street;
    private double latitude;
    private double longitude;
    private int slotCount;
    private int bikeCount = 0;



    public Station(String city, String street, double latitude, double longitude, int slotCount) {
        this.city = city;
        this.street = street;
        this.latitude = latitude;
        this.longitude = longitude;
        this.slotCount = slotCount;
    }
    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getSlotCount() {
        return slotCount;
    }

    public void setSlotCount(int slotCount) {
        this.slotCount = slotCount;
    }

    public int getBikeCount() {
        return bikeCount;
    }

    public void setBikeCount(int bikeCount) {
        this.bikeCount = bikeCount;
    }

}
