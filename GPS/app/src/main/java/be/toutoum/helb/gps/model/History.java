package be.toutoum.helb.gps.model;

public class History {

    private long id;
    private int num;
    private String street;
    private String town;
    private String country;

    public History(int num, String street, String town, String country) {
        this.num = num;
        this.street = street;
        this.town = town;
        this.country = country;
    }

    public History(long id, int num, String street, String town, String country) {
        this.id = id;
        this.num = num;
        this.street = street;
        this.town = town;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
