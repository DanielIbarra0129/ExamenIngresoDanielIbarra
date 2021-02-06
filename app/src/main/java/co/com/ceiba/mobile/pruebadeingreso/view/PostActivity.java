package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.PostUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.User;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Presenter.PresenterPost;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Presenter.PresenterPostImpl;
import co.com.ceiba.mobile.pruebadeingreso.MVP.View.Adaptaders.PostAdapter;
import co.com.ceiba.mobile.pruebadeingreso.MVP.View.ViewPost;
import co.com.ceiba.mobile.pruebadeingreso.R;

public class PostActivity extends AppCompatActivity implements ViewPost {

    ProgressDialog progressDialog;
    User user;
    RecyclerView recyclerView;
    PresenterPost presenterPost;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        user = (User) getIntent().getSerializableExtra("user");

        if (user==null){
            Toast.makeText(getApplicationContext(), getString(R.string.error_usuario),Toast.LENGTH_SHORT).show();
            finish();
        }
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        presenterPost = new PresenterPostImpl(this, getApplicationContext());
        postAdapter = new PostAdapter(new ArrayList<>());
        recyclerView = findViewById(R.id.recyclerViewPostsResults);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(postAdapter);
        TextView tvName = findViewById(R.id.name);
        TextView tvPhone = findViewById(R.id.phone);
        TextView tvEmail = findViewById(R.id.email);
        tvName.setText((user.getName()!=null) ? user.getName() : "");
        tvPhone.setText((user.getPhone()!=null) ? user.getPhone() : "");
        tvEmail.setText((user.getEmail()!=null) ? user.getEmail() : "");

        getPostUserId(user.getId());


    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    public void getPostUserId(String userId) {
        showDialogCargando(R.string.informacion, R.string.consultando_posts);
        new Handler().postDelayed(() -> {
            presenterPost.getPostByUserId(userId);
        },1000);
    }

    @Override
    public void getAllPost() {
    }

    @Override
    public void showPostByUser(List<PostUser> postUsers) {
        cancelDialogCargando();
        postAdapter.setPostList(postUsers);
    }

    @Override
    public void showAlertDialogInf(int titulo, int mensaje) {
        cancelDialogCargando();
        Toast.makeText(getApplicationContext(), getString(titulo)+" : "+getString(mensaje), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAlertDialogInf(int titulo, String mensaje) {
        cancelDialogCargando();
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
}
