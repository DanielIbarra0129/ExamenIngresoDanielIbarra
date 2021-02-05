package co.com.ceiba.mobile.pruebadeingreso.MVP.View;

public interface ViewGeneral {

    void showAlertDialogInf(int titulo, int mensaje);

    void showAlertDialogInf(int titulo, String mensaje);

    void showDialogCargando(int titulo, int mensaje);

    void cancelDialogCargando();

}
