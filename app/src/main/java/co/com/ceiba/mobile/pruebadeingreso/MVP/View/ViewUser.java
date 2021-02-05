package co.com.ceiba.mobile.pruebadeingreso.MVP.View;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.User;

public interface ViewUser extends ViewGeneral{
    void getUser();

    void showUser(List<User> userList);
}
