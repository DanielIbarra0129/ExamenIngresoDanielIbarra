package co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo;

import java.util.List;

public interface RepositoryPost extends RepositoryGeneral{
    void getPostUserId(String userId);

    void getAllPost();

    void setAllPost (List<PostUser> listPost);
}
