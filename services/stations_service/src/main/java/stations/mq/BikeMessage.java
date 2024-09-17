package stations.mq;


import java.io.Serializable;

public class BikeMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String stationId;

    public BikeMessage(int id, String stationId) {
        this.id = id;
        this.stationId = stationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationId() {
        return stationId;
    }

    public void setLocationId(String stationId) {
        this.stationId = stationId;
    }
}
