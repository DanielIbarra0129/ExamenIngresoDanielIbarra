package co.com.ceiba.mobile.pruebadeingreso.MVP.Presenter;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.User;

public interface PresenterUser extends PresenterGeneral, PresenterPost{
    void getUser();

    void showUser(List<User> listUser);
}
