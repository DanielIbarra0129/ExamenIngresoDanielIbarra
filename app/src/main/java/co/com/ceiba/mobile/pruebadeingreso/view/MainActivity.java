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
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis.PostUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis.User;
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
    private View viewEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenterUser = new PresenterUserImpl(this, getApplicationContext());
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        userAdapter = new UserAdapter(new ArrayList<>(), interfaceUser());
        recyclerView = findViewById(R.id.recyclerViewSearchResults);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        RelativeLayout contentLayout = findViewById(R.id.content);
        viewEmpty = layoutInflater.inflate(R.layout.empty_view, contentLayout, false);
        contentLayout.addView(viewEmpty);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(userAdapter);
        recyclerView.setVisibility(View.GONE);
        viewEmpty.setVisibility(View.VISIBLE);
        EditText etSearch = findViewById(R.id.editTextSearch);
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
                if (userAdapter.filter(editable.toString())){
                    recyclerView.setVisibility(View.VISIBLE);
                    viewEmpty.setVisibility(View.GONE);
                } else {
                    recyclerView.setVisibility(View.GONE);
                    viewEmpty.setVisibility(View.VISIBLE);
                }
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
        Log.d("Usuarios obtenidos", userList.toString());
        cancelDialogCargando();
        if (userList.isEmpty()){
            viewEmpty.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            userAdapter.setUserListOrigin(userList);
            viewEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }


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