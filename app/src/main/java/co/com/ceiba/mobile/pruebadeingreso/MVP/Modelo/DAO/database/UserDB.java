package co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.DAO.database;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.DAO.UserDao;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.User;

public class UserDB {

    private static UserDB userDB;

    private UserDao userDao;

    private UserDB(Context context) {
        Context appContext = context.getApplicationContext();
        UserRoomDatabase database = Room.databaseBuilder(appContext, UserRoomDatabase.class, "user_database")
                .allowMainThreadQueries().build();
        userDao = database.getUserDao();
    }

    public static UserDB getInstance(Context context){
        if (userDB !=null) return userDB;
        userDB = new UserDB(context);
        return userDB;
    }

    public List<User> getUser () {
        return userDao.getUserDao();
    }

    public void setUser (User user) {
        userDao.insertUser(user);
    }

    public void deleteUsers () {
        userDao.deleteAllUser();
    }


}
