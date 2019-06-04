package co.com.ceiba.mobile.pruebadeingreso.models;

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    Geo geo;


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getgeo() {
        return geo;
    }

    public void setgeo(Geo geoObject) {
        geo = geoObject;
    }
}
