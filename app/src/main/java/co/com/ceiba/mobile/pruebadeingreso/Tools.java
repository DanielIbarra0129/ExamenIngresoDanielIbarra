package co.com.ceiba.mobile.pruebadeingreso;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class Tools {
    public static void ocultarTeclado (Context context, EditText editText) {
        editText.clearFocus();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
