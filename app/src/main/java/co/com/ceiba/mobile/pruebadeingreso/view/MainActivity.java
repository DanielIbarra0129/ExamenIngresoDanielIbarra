package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.PostUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.User;
import co.com.ceiba.mobile.pruebadeingreso.MVP.presenter.PresenterUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.presenter.PresenterUserImpl;
import co.com.ceiba.mobile.pruebadeingreso.MVP.UserSelected;
import co.com.ceiba.mobile.pruebadeingreso.MVP.view.Adaptaders.UserAdapter;
import co.com.ceiba.mobile.pruebadeingreso.MVP.view.ViewPost;
import co.com.ceiba.mobile.pruebadeingreso.MVP.view.ViewUser;
import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.Tools;

public class MainActivity extends AppCompatActivity implements ViewUser, ViewPost {

    private ProgressDialog progressDialog;
    private PresenterUser presenterUser;
    private UserAdapter userAdapter;
    private RecyclerView recyclerView;
    private EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenterUser = new PresenterUserImpl(this, getApplicationContext());
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        userAdapter = new UserAdapter(new ArrayList<>(), interfaceUser());
        recyclerView = findViewById(R.id.recyclerViewSearchResults);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(userAdapter);
        etSearch = findViewById(R.id.editTextSearch);
        Tools.ocultarTeclado(getApplicationContext(), etSearch);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                userAdapter.filter(editable.toString());
            }
        });

        getUser();
        getAllPost();

    }

    public UserSelected interfaceUser() {
        return user -> {
            Intent intent = new Intent(getApplicationContext(), PostActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        };
    }

    @Override
    public void getUser() {
        showDialogCargando(R.string.informacion, R.string.consultando_usuarios);
        new Handler().postDelayed(() -> presenterUser.getUser(),1000);

    }

    @Override
    public void showUser(List<User> userList) {
        cancelDialogCargando();
        Log.d("Usuarios obtenidos", userList.toString());
        userAdapter.setUserListOrigin(userList);
    }

    @Override
    public void showAlertDialogInf(int titulo, int mensaje) {
        cancelDialogCargando();
        Toast.makeText(getApplicationContext(), getString(titulo) + " : " + getString(mensaje), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAlertDialogInf(int titulo, String mensaje) {
        cancelDialogCargando();
        Toast.makeText(getApplicationContext(), getString(titulo) + " : " + mensaje, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialogCargando(int titulo, int mensaje) {
        cancelDialogCargando();
        progressDialog.setTitle(getString(titulo));
        progressDialog.setMessage(getString(mensaje));
        progressDialog.show();
    }

    @Override
    public void cancelDialogCargando() {
        if (progressDialog.isShowing()) progressDialog.dismiss();
    }

    @Override
    public void getPostUserId(String userId) {

    }

    @Override
    public void getAllPost() {
        presenterUser.getAllPost();
    }

    @Override
    public void showPostByUser(List<PostUser> postUsers) {
        //No requerido
    }
}