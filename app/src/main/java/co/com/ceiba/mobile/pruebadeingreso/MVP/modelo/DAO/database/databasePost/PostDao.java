package co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.DAO.database.databasePost;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis.PostUser;

@Dao
public interface PostDao {

    @Query("SELECT * FROM post_table")
    List<PostUser> getPostDao ();

    @Query("SELECT * FROM post_table WHERE userId LIKE :idUser")
    List<PostUser> getPostDaoById (String idUser);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPost (PostUser post);

    @Query("DELETE FROM post_table")
    void deleteAllPost ();
}
