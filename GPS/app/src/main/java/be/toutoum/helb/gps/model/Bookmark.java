package be.toutoum.helb.gps.model;

public class Bookmark {

    private long id;
    private String name;
    private long latitude;
    private long longitude;

    public Bookmark(String name, long latitude, long longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Bookmark(long id, String name, long latitude, long longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

}
