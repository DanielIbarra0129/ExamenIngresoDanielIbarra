package co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.DAO.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.DAO.PostDao;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.PostUser;

@Database(entities = {PostUser.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class PostRoomDatabase extends RoomDatabase {
    public abstract PostDao getPostDao();
}
