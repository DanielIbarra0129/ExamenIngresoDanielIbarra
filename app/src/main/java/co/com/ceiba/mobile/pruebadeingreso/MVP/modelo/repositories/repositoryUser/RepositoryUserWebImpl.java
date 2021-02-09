package co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.repositories.repositoryUser;

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

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis.PostUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis.User;
import co.com.ceiba.mobile.pruebadeingreso.MVP.presenter.PresenterUser;
import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints;

public class RepositoryUserWebImpl implements RepositoryUser {

    Context context;
    PresenterUser presenterUser;
    List<User> userList=new ArrayList<>();

    public RepositoryUserWebImpl(Context context, PresenterUser presenterUser) {
        this.context = context;
        this.presenterUser = presenterUser;
    }

    @Override
    public void getUsers() {
        if (!verificarConexion()) {
            presenterUser.showErrorMessageDialog(R.string.informacion, R.string.verifique_conexion);
            return;
        }



        RequestQueue queue = Volley.newRequestQueue(context);
        String url = Endpoints.URL_BASE+Endpoints.GET_USERS;

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
            Log.d("Respuesta servicio", response.toString());
            Gson gson = new GsonBuilder().create();

            if (response.length()==0){
                presenterUser.showErrorMessageDialog(R.string.informacion, R.string.sin_información);
                return;
            }

            for (int i=0; i<response.length();i++){
                try {
                    userList.add(gson.fromJson(response.getJSONObject(i).toString(), User.class));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            presenterUser.showUserWeb(userList);

        }, error -> {
            presenterUser.showErrorMessageDialog(R.string.informacion, R.string.error_servidor);
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return new HashMap<>();
            }
        };
        queue.add(jsonObjectRequest);
    }

    @Override
    public void setUser(List<User> userList) {
    }

    @Override
    public List<User> getUserSaved() {
        return userList;
    }

    @Override
    public List<User> userFiltered(String stringFiltered) {
        return null;
    }

    @Override
    public boolean verificarConexion() {
        ConnectivityManager con = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = con.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }

    @Override
    public void getPostUserId(String userId) {
        if (!verificarConexion()) {
            presenterUser.showErrorMessageDialog(R.string.informacion, R.string.verifique_conexion);
            return;
        }

        RequestQueue queue = Volley.newRequestQueue(context);
        String url = Endpoints.URL_BASE+Endpoints.GET_POST_USER+userId;

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    Log.d("Respuesta servicio POST", response.toString());
                    Gson gson = new GsonBuilder().create();

                    List<PostUser> postUserList = new ArrayList<>();

                    for (int i =0; i<response.length(); i++){
                        try {
                            postUserList.add(gson.fromJson(response.getJSONObject(i).toString(), PostUser.class));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    presenterUser.showAllPostWeb(postUserList);



                }, error -> {
            Log.d("Error", error.toString());
            presenterUser.showErrorMessageDialog(R.string.informacion, R.string.error_servidor);
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return new HashMap<>();
            }
        };
        queue.add(jsonObjectRequest);
    }

    @Override
    public void getAllPost() {
        Log.d("RepositoryUserWebImpl","getAllPost");
        if (!verificarConexion()) {
            presenterUser.showErrorMessageDialog(R.string.informacion, R.string.verifique_conexion);
            return;
        }

        RequestQueue queue = Volley.newRequestQueue(context);
        String url = Endpoints.URL_BASE+Endpoints.GET_ALL_POST;

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
            Log.d("Respuesta servicio POST", response.toString());
            Gson gson = new GsonBuilder().create();

            List<PostUser> postUserList = new ArrayList<>();

            for (int i =0; i<response.length(); i++){
                try {
                    postUserList.add(gson.fromJson(response.getJSONObject(i).toString(), PostUser.class));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            presenterUser.showAllPostWeb(postUserList);



        }, error ->{
            presenterUser.showErrorMessageDialog(R.string.informacion, R.string.error_servidor);
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return new HashMap<>();
            }
        };
        queue.add(jsonObjectRequest);

    }

    @Override
    public void setAllPost(List<PostUser> listPost) {

    }
}
