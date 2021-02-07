package co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.repositories.repositoryPost;

import android.content.Context;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.DAO.database.databasePost.PostDB;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis.PostUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.presenter.PresenterPost;

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
        presenterPost.getAllPost();
    }

    @Override
    public void setAllPost(List<PostUser> listPost) {
        for (PostUser postUser : listPost){
            postDB.setPost(postUser);
        }
    }
}
