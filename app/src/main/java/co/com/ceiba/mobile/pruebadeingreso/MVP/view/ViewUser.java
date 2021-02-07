package co.com.ceiba.mobile.pruebadeingreso.MVP.view;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis.User;

public interface ViewUser extends ViewGeneral{
    void getUser();

    void showUser(List<User> userList);
}
