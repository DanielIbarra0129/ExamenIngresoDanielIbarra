package co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo;

public interface RepositoryUser {

    boolean verificarConexion();

    void getUserFromWebServices();

    void getUserFromDatabase();

    void getPostUserIdWebService(String userId);

    void getAllPostWebService();

    void getPostUserIdFromDatabase(String userId);

    void getAllPostFromDatabase();


}
