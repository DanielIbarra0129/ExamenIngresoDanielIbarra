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

import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.PostUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.User;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Presenter.PresenterUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Presenter.PresenterUserImpl;
import co.com.ceiba.mobile.pruebadeingreso.MVP.UserSelected;
import co.com.ceiba.mobile.pruebadeingreso.MVP.View.Adaptaders.UserAdapter;
import co.com.ceiba.mobile.pruebadeingreso.MVP.View.ViewPost;
import co.com.ceiba.mobile.pruebadeingreso.MVP.View.ViewUser;
import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.Tools;

public class MainActivity extends AppCompatActivity implements ViewUser, ViewPost {

    //eliminar sgte variable
    public static List<PostUser> POST_USER_ALL = new ArrayList<>();
    public static List<PostUser> POST_USER_BY_ID = new ArrayList<>();

    ProgressDialog progressDialog;
    PresenterUser presenterUser;
    UserAdapter userAdapter;
    RecyclerView recyclerView;
    EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenterUser = new PresenterUserImpl(this, getApplicationContext());
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        userAdapter = new UserAdapter(new ArrayList<User>(), interfaceUser());
        recyclerView=findViewById(R.id.recyclerViewSearchResults);
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

        showDialogCargando(R.string.informacion, R.string.consultando_usuarios);
        new Handler().postDelayed(() -> {
            getUser();
            getAllPost();
        },5000);

    }

    public UserSelected interfaceUser (){
        return user -> {
            Intent intent = new Intent(getApplicationContext(), PostActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    public void getUser() {
        presenterUser.getUser();
    }

    @Override
    public void showUser(List<User> userList) {
        cancelDialogCargando();
        Log.d("Usuarios obtenidos", userList.toString());
        userAdapter.setUserListOrigin(userList);
    }

    @Override
    public void showAlertDialogInf(int titulo, int mensaje) {
        Toast.makeText(getApplicationContext(), getString(titulo)+" : "+getString(mensaje), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAlertDialogInf(int titulo, String mensaje) {
        Toast.makeText(getApplicationContext(), getString(titulo)+" : "+mensaje, Toast.LENGTH_SHORT).show();
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

    }
}