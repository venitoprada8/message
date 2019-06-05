package co.com.ceiba.mobile.pruebadeingreso.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "users")
public class Users {
    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "id")
    private float id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "username")
    private String username;
    @ColumnInfo(name = "email")
    private String email;
    @Embedded
    private Address address;
    @ColumnInfo(name = "phone")
    private String phone;
    @ColumnInfo(name = "website")
    private String website;
    @Embedded
    private  Company company;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
