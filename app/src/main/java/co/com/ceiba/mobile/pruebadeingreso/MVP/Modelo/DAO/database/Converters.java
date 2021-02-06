package co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.DAO.database;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.Address;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.Company;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.Location;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.User;

public class Converters {
    @TypeConverter
    public static Location stringToLocation(String location) {
        Gson gson= new GsonBuilder().create();
        return gson.fromJson(location, Location.class);
    }

    @TypeConverter
    public static String locationToString (Location location) {
        Gson gson= new GsonBuilder().create();
        return gson.toJson(location);
    }

    @TypeConverter
    public static Address stringToAddress(String addres) {
        Gson gson= new GsonBuilder().create();
        return gson.fromJson(addres, Address.class);
    }

    @TypeConverter
    public static String addressToString (Address address) {
        Gson gson= new GsonBuilder().create();
        return gson.toJson(address);
    }

    @TypeConverter
    public static User stringToUser (String user) {
        Gson gson= new GsonBuilder().create();
        return gson.fromJson(user, User.class);
    }

    @TypeConverter
    public static String userToString (User user) {
        Gson gson= new GsonBuilder().create();
        return gson.toJson(user);
    }

    @TypeConverter
    public static Company stringToCompany (String company) {
        Gson gson= new GsonBuilder().create();
        return gson.fromJson(company, Company.class);
    }

    @TypeConverter
    public static String companyToString (Company company) {
        Gson gson= new GsonBuilder().create();
        return gson.toJson(company);
    }


}
