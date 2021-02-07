package co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.DAO.database.databasePost;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.DAO.database.Converters;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis.PostUser;

@Database(entities = {PostUser.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class PostRoomDatabase extends RoomDatabase {
    public abstract PostDao getPostDao();
}
