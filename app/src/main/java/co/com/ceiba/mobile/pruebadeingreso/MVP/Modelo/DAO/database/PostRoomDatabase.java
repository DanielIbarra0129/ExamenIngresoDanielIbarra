package co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.DAO.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.DAO.PostDao;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.DAO.UserDao;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.PostUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.User;

@Database(entities = {PostUser.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class PostRoomDatabase extends RoomDatabase {
    public abstract PostDao getPostDao();
}
