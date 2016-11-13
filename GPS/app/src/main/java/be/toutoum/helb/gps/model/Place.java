package be.toutoum.helb.gps.model;

public class Place {
    private int id;
    private String nickname;
    private double longitude;
    private double latitude;
    private int num;
    private String street;
    private String town;
    private String Country;
    private int type; // 0 = bookmark - 1 = history

    public Place() {
    }

    // add History
    public Place(int num, String street, String town, String country) {
        this.num = num;
        this.street = street;
        this.town = town;
        Country = country;
        this.type = 1;
    }

    // add bookmark
    public Place(String nickname, double longitude, double latitude, int num, String street, String town, String country) {
        this.nickname = nickname;
        this.longitude = longitude;
        this.latitude = latitude;
        this.num = num;
        this.street = street;
        this.town = town;
        Country = country;
        this.type = 0;
    }

    public Place(int id, String nickname, double longitude, double latitude, int num, String street, String town, String country, int type) {
        this.id = id;
        this.nickname = nickname;
        this.longitude = longitude;
        this.latitude = latitude;
        this.num = num;
        this.street = street;
        this.town = town;
        Country = country;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        if (type == 0)
            return nickname + "\n" + num +
                    ' ' + street + ' ' + town + ' ' + Country;
        else
            return num + ' ' + street + ' ' + town + ' ' + Country;
    }
}