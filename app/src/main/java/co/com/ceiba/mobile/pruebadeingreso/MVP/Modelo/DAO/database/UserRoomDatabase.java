package co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.DAO.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.DAO.UserDao;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.User;

@Database(entities = {User.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class UserRoomDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
