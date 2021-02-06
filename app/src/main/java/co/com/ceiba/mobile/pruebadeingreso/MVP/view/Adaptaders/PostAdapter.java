package co.com.ceiba.mobile.pruebadeingreso.MVP.view.Adaptaders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.PostUser;
import co.com.ceiba.mobile.pruebadeingreso.R;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.UserHolder> {

    List<PostUser> postUserList;

    public PostAdapter(List<PostUser> postUserList) {
        this.postUserList = postUserList;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return postUserList.size();
    }

    public void setPostList(List<PostUser> postUserList) {
        this.postUserList.clear();
        this.postUserList.addAll(postUserList);
        notifyDataSetChanged();
    }

    public class UserHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvBody;

        public UserHolder(View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.title);
            this.tvBody = itemView.findViewById(R.id.body);
            }

        public void setData (int position){
            this.tvTitle.setText(postUserList.get(position).getTitle());
            this.tvBody.setText(postUserList.get(position).getBody());
        }
    }
}
