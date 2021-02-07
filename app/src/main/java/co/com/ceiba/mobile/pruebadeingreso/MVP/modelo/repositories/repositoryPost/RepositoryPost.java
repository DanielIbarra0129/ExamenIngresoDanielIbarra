package co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.repositories.repositoryPost;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis.PostUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.repositories.RepositoryGeneral;

public interface RepositoryPost extends RepositoryGeneral {
    void getPostUserId(String userId);

    void getAllPost();

    void setAllPost (List<PostUser> listPost);
}
