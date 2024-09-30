package bikes.broker;


import java.io.Serializable;

public class BikeMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String locationId;

    public BikeMessage(int id, String locationId) {
        this.id = id;
        this.locationId = locationId;
    }

    public BikeMessage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}
