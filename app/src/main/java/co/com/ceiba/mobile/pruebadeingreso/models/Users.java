package co.com.ceiba.mobile.pruebadeingreso.models;

public class Users {
    private float id;
    private String name;
    private String username;
    private String email;
    Address AddressObject;
    private String phone;
    private String website;
    Company CompanyObject;

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddressObject() {
        return AddressObject;
    }

    public void setAddressObject(Address addressObject) {
        AddressObject = addressObject;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompanyObject() {
        return CompanyObject;
    }

    public void setCompanyObject(Company companyObject) {
        CompanyObject = companyObject;
    }
}
