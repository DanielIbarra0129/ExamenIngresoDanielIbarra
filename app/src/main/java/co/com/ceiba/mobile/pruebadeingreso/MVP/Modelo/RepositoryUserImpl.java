package co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.com.ceiba.mobile.pruebadeingreso.MVP.Presenter.PresenterUser;
import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints;

public class RepositoryUserImpl implements RepositoryUser {

    Context context;
    PresenterUser presenterUser;

    public RepositoryUserImpl(Context context, PresenterUser presenterUser) {
        this.context = context;
        this.presenterUser = presenterUser;
    }

    @Override
    public void getUserFromWebServices() {
        if (!verificarConexion()) {
            presenterUser.showErrorMessageDialog(R.string.informacion, R.string.verifique_conexion);
            return;
        }

        final List<User> userList=new ArrayList<>();

        RequestQueue queue = Volley.newRequestQueue(context);
        String url = Endpoints.URL_BASE+Endpoints.GET_USERS;

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
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

                presenterUser.showUser(userList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.toString());
            }
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
    public void getUserFromDatabase() {

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
    public void getPostUserIdWebService(String userId) {

    }

    @Override
    public void getAllPostWebService() {

        if (!verificarConexion()) {
            presenterUser.showErrorMessageDialog(R.string.informacion, R.string.verifique_conexion);
            return;
        }

        RequestQueue queue = Volley.newRequestQueue(context);
        String url = Endpoints.URL_BASE+Endpoints.GET_ALL_POST;

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("Respuesta servicio POST", response.toString());
                Gson gson = new GsonBuilder().create();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.toString());
            }
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
    public void getPostUserIdFromDatabase(String userId) {

    }

    @Override
    public void getAllPostFromDatabase() {

    }
}
