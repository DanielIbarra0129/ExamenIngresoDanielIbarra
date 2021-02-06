package co.com.ceiba.mobile.pruebadeingreso.MVP.view;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.User;

public interface ViewUser extends ViewGeneral{
    void getUser();

    void showUser(List<User> userList);
}
