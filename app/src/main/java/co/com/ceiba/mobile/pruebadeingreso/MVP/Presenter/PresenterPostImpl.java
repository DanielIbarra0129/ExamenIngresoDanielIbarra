package co.com.ceiba.mobile.pruebadeingreso.MVP.Presenter;

import android.content.Context;
import android.util.Log;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.PostUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.RepositoryPost;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.RepositoryPostDBImpl;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.RepositoryPostWebImpl;
import co.com.ceiba.mobile.pruebadeingreso.MVP.View.ViewPost;

public class PresenterPostImpl implements PresenterPost{

    ViewPost viewPost;
    RepositoryPost repositoryPostWebService;
    RepositoryPost repositoryPostDB;
    String userId = "";


    public PresenterPostImpl(ViewPost viewPost, Context context) {
        repositoryPostWebService = new RepositoryPostWebImpl(this, context);
        repositoryPostDB = new RepositoryPostDBImpl(this, context);
        this.viewPost = viewPost;
    }

    @Override
    public void getPostByUserId(String userId) {
        this.userId =userId;
        repositoryPostDB.getPostUserId(userId);
    }

    @Override
    public void showPostByUserIdWeb(List<PostUser> postUserList) {
        viewPost.showPostByUser(postUserList);
    }

    @Override
    public void showPostByUserIdDB(List<PostUser> postUserList) {
        if (postUserList.isEmpty()){
            repositoryPostWebService.getPostUserId(userId);
        } else {
            viewPost.showPostByUser(postUserList);
        }
    }

    @Override
    public void getAllPost() {
    }

    @Override
    public void guardarInfoDatabasePost(List<PostUser> postUserList) {
        Log.d("PresenterPostImpl","guardarInfoDatabasePost");
    }

    @Override
    public void showAllPostWeb(List<PostUser> postUserList) {
        guardarInfoDatabasePost(postUserList);
    }

    @Override
    public void showAllPostDB(List<PostUser> postUserList) {
    }

    @Override
    public void showErrorMessageDialog(int titulo, int mensaje) {
        viewPost.showAlertDialogInf(titulo, mensaje);
    }

    @Override
    public void showErrorMessageDialog(int titulo, String mensaje) {
        viewPost.showAlertDialogInf(titulo, mensaje);
    }

    @Override
    public void cancelarDialogoCargando() {
        viewPost.cancelDialogCargando();
    }
}
