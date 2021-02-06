package co.com.ceiba.mobile.pruebadeingreso.MVP.presenter;

public interface PresenterGeneral {

    void showErrorMessageDialog(int titulo, int mensaje);

    void showErrorMessageDialog(int titulo, String mensaje);

    void cancelarDialogoCargando();
}
