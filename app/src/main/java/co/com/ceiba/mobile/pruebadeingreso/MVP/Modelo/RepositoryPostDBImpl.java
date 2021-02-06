package co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.DAO.database.PostDB;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Presenter.PresenterPost;
import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints;

public class RepositoryPostDBImpl implements RepositoryPost{

    PresenterPost presenterPost;
    Context context;
    PostDB postDB;

    public RepositoryPostDBImpl(PresenterPost presenterPost, Context context) {
        this.presenterPost = presenterPost;
        this.context = context;
        postDB = PostDB.getInstance(context);
    }
    @Override
    public boolean verificarConexion() {
        return false;
    }

    @Override
    public void getPostUserId(String userId) {
        presenterPost.showPostByUserIdDB(postDB.getPostById(userId));
    }

    @Override
    public void getAllPost() {
    }

    @Override
    public void setAllPost(List<PostUser> listPost) {
        for (PostUser postUser : listPost){
            postDB.setPost(postUser);
        }
    }
}
