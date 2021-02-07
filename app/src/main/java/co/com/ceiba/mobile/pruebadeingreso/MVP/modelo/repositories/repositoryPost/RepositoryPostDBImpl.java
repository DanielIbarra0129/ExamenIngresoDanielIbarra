package co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.repositories.repositoryPost;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.DAO.database.databasePost.PostDB;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis.PostUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.presenter.PresenterPost;

public class RepositoryPostDBImpl implements RepositoryPost{

    PresenterPost presenterPost;
    Context context;
    PostDB postDB;
    List<PostUser> list = new ArrayList<>();

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
        list = postDB.getPostById(userId);
        presenterPost.showPostByUserIdDB((list!= null) ? list : new ArrayList<>());
    }

    @Override
    public void getAllPost() {
        presenterPost.getAllPost();
    }

    @Override
    public void setAllPost(List<PostUser> listPost) {
        for (PostUser postUser : listPost){
            postDB.setPost(postUser);
        }
    }
}
