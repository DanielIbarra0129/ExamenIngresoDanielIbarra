package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.User;
import co.com.ceiba.mobile.pruebadeingreso.R;

public class PostActivity extends Activity {

    User user;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        user = (User) getIntent().getSerializableExtra("user");

        if (user==null){
            Toast.makeText(getApplicationContext(), getString(R.string.error_usuario),Toast.LENGTH_SHORT).show();
            finish();
        }
        recyclerView = findViewById(R.id.recyclerViewPostsResults);
        TextView tvName = findViewById(R.id.name);
        TextView tvPhone = findViewById(R.id.phone);
        TextView tvEmail = findViewById(R.id.email);
        tvName.setText((user.getName()!=null) ? user.getName() : "");
        tvPhone.setText((user.getPhone()!=null) ? user.getPhone() : "");
        tvEmail.setText((user.getEmail()!=null) ? user.getEmail() : "");

    }

    @Override
    protected void onStart() {
        super.onStart();
    }


}
