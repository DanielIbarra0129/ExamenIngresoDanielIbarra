package co.com.ceiba.mobile.pruebadeingreso.MVP.presenter;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis.User;

public interface PresenterUser extends PresenterGeneral, PresenterPost{
    void getUser();

    void showUserDB(List<User> listUser);

    void showUserWeb(List<User> listUser);

    void guardarInfoDatabaseUser(List<User> userList);
}
