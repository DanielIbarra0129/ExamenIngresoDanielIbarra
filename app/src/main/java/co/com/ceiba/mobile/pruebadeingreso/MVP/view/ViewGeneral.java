package co.com.ceiba.mobile.pruebadeingreso.MVP.view;

public interface ViewGeneral {

    void showAlertDialogInf(int titulo, int mensaje);

    void showAlertDialogInf(int titulo, String mensaje);

    void showDialogCargando(int titulo, int mensaje);

    void cancelDialogCargando();

}
