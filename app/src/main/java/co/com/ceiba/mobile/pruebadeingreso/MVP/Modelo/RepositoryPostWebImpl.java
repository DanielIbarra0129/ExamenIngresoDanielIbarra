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

import co.com.ceiba.mobile.pruebadeingreso.MVP.Presenter.PresenterPost;
import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints;

public class RepositoryPostWebImpl implements RepositoryPost{

    PresenterPost presenterPost;
    Context context;

    public RepositoryPostWebImpl(PresenterPost presenterPost, Context context) {
        this.presenterPost = presenterPost;
        this.context = context;
    }
    @Override
    public boolean verificarConexion() {
        ConnectivityManager con = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = con.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    @Override
    public void getPostUserId(String userId) {
        if (!verificarConexion()) {
            presenterPost.showErrorMessageDialog(R.string.informacion, R.string.verifique_conexion);
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

                    presenterPost.showPostByUserIdWeb(postUserList);

                }, error -> {
            Log.d("Error", error.toString());
            presenterPost.showErrorMessageDialog(R.string.informacion, R.string.error_servidor);
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        queue.add(jsonObjectRequest);
    }

    @Override
    public void getAllPost() {
        Log.d("RepositoryUserWebImpl","getAllPost");
        if (!verificarConexion()) {
            presenterPost.showErrorMessageDialog(R.string.informacion, R.string.verifique_conexion);
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

                    presenterPost.showAllPostWeb(postUserList);



                }, error -> {
            Log.d("Error", error.toString());
            presenterPost.showErrorMessageDialog(R.string.informacion, R.string.error_servidor);
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        queue.add(jsonObjectRequest);

    }

    @Override
    public void setAllPost(List<PostUser> listPost) {

    }
}
