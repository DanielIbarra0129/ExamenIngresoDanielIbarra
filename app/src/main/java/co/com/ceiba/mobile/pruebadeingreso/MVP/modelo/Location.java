package co.com.ceiba.mobile.pruebadeingreso.MVP.modelo;

import android.arch.persistence.room.Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "location_table")
public class Location implements Serializable {
    @SerializedName(value = "lat")
    private String latitude;
    @SerializedName(value = "lng")
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
