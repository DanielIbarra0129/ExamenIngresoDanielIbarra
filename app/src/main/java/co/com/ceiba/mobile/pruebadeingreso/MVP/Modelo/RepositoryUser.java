package co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo;

import java.util.List;

public interface RepositoryUser extends RepositoryPost, RepositoryGeneral{

    void getUsers();

    void setUser(List<User> userList);


}
