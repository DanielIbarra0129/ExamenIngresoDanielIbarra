package co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.DAO.database;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.DAO.PostDao;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.PostUser;

public class PostDB {

    private static PostDB postDB;

    private PostDao postDao;

    private PostDB (Context context) {
        Context appContext = context.getApplicationContext();
        PostRoomDatabase database = Room.databaseBuilder(appContext, PostRoomDatabase.class, "post_database")
                .allowMainThreadQueries().build();
        postDao = database.getPostDao();
    }

    public static PostDB getInstance(Context context) {
        if (postDB!=null) return postDB;

        postDB = new PostDB(context);
        return postDB;
    }

    public List<PostUser> getPost () {
        return postDao.getPostDao();
    }

    public void setPost (PostUser post) {
        postDao.insertPost(post);
    }

    public void deleteUsers () {
        postDao.deleteAllPost();
    }

    public List<PostUser> getPostById (String idUser) {
        return postDao.getPostDaoById(idUser);
    }

}
