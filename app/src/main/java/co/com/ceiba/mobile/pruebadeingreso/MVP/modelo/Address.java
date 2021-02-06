package co.com.ceiba.mobile.pruebadeingreso.MVP.modelo;

import android.arch.persistence.room.Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "address_table")
public class Address implements Serializable {
    private String street;
    private String suite;
    private String city;
    @SerializedName(value = "zipcode")
    private String zipCode;
    @SerializedName(value = "geo")
    private Location location;

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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
