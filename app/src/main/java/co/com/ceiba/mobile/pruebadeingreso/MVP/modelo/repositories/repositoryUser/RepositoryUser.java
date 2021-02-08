package co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.repositories.repositoryUser;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis.User;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.repositories.RepositoryGeneral;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.repositories.repositoryPost.RepositoryPost;

public interface RepositoryUser extends RepositoryPost, RepositoryGeneral {

    void getUsers();

    void setUser(List<User> userList);

    List<User> getUserSaved ();

}
