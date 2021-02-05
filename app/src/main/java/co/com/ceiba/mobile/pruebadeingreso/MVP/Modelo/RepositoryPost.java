package co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo;

public interface RepositoryPost extends RepositoryGeneral{
    void getPostUserId(String userId);

    void getAllPost();
}
