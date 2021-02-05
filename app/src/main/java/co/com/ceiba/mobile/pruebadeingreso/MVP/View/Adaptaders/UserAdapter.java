package co.com.ceiba.mobile.pruebadeingreso.MVP.View.Adaptaders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.stream.Collectors;

import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.User;
import co.com.ceiba.mobile.pruebadeingreso.MVP.UserSelected;
import co.com.ceiba.mobile.pruebadeingreso.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    List<User> userListOrigin;
    List<User> userListFiltered;
    UserSelected userSelected;

    public UserAdapter(List<User> userListOrigin, UserSelected userSelected) {
        this.userListOrigin = userListOrigin;
        this.userListFiltered= userListOrigin;
        this.userSelected = userSelected;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return userListFiltered.size();
    }

    public void setUserListOrigin(List<User> userListOrigin) {
        this.userListOrigin.clear();
        this.userListOrigin.addAll(userListOrigin);
        this.userListFiltered = userListOrigin;
        notifyDataSetChanged();
    }

    public void filter (String stringFiltered) {
        stringFiltered = stringFiltered.toLowerCase();
        userListFiltered.clear();
        if (stringFiltered.length()==0){
            userListFiltered.addAll(userListOrigin);
            notifyDataSetChanged();
            return;
        }

        for (User user: userListOrigin){
            if (user.getName().toLowerCase().contains(stringFiltered)) userListFiltered.add(user);
        }

        notifyDataSetChanged();
    }

    public class UserHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvPhone;
        TextView tvEmail;
        Button btnVerPub;
        User user;

        public UserHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.name);
            tvPhone = itemView.findViewById(R.id.phone);
            tvEmail = itemView.findViewById(R.id.email);
            btnVerPub = itemView.findViewById(R.id.btn_view_post);
            btnVerPub.setOnClickListener(view ->{
                userSelected.getUser(this.user);
            });
        }

        public void setData (int position){
            if (userListFiltered.size()==0) return;
            this.user = userListFiltered.get(position);
            this.tvName.setText(user.getName());
            tvPhone.setText(user.getPhone());
            tvEmail.setText(user.getEmail());
        }
    }
}
