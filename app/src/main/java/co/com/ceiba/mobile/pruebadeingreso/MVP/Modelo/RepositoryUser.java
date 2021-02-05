package co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo;

public interface RepositoryUser {
    void getUserFromWebServices();

    void getUserFromDatabase();

    boolean verificarConexion();
}
