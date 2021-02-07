package co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.DAO.database.repositoryUser;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user_table")
    List<User> getUserDao ();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUser (User user);

    @Query("DELETE FROM user_table")
    void deleteAllUser ();
}
