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
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.DAO.database.UserDB;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Presenter.PresenterUser;
import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints;

public class RepositoryUserDatabaseImpl implements RepositoryUser {

    private Context context;
    private PresenterUser presenterUser;
    private UserDB userDB;
    private PostDB postDB;

    public RepositoryUserDatabaseImpl(Context context, PresenterUser presenterUser) {
        this.context = context;
        this.presenterUser = presenterUser;
        userDB = UserDB.getInstance(context);
        postDB = PostDB.getInstance(context);
    }
    /**
     * DEVOLVEMOS VALORES NULOS SIMULANDO QUE DB NO TIENE REGISTROS
     * **/

    @Override
    public void getUsers() {
        Log.d("RepositoryUserDBImpl","getUser");

        List<User> userList;
        userList = userDB.getUser();
        System.out.println("userList.SIZE -> "+userList.size());
        presenterUser.showUserDB(userList);

    }

    @Override
    public void setUser(List<User> userList) {
        Log.d("RepositoryUserDBImpl","setUser");
        for (int i=0; i<userList.size(); i++){
            userDB.setUser(userList.get(i));
        }
    }

    @Override
    public void getPostUserId(String userId) {
       postDB.getPostById(userId);
    }

    @Override
    public void getAllPost() {
        presenterUser.showAllPostDB(postDB.getPost());
    }

    @Override
    public void setAllPost(List<PostUser> listPost) {
        for (PostUser postUser : listPost){
            postDB.setPost(postUser);
        }
    }

    @Override
    public boolean verificarConexion() {
        return false;
    }
}
