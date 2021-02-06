package co.com.ceiba.mobile.pruebadeingreso.MVP.Presenter;

import android.content.Context;
import android.util.Log;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.PostUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.RepositoryUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.RepositoryUserDatabaseImpl;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.RepositoryUserWebImpl;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.User;
import co.com.ceiba.mobile.pruebadeingreso.MVP.View.ViewUser;

public class PresenterUserImpl implements PresenterUser {

    ViewUser viewUser;
    RepositoryUser repositoryUserWebService;
    RepositoryUser repositoryUserDatabase;

    public PresenterUserImpl(ViewUser viewUser, Context context) {
        this.viewUser = viewUser;
        repositoryUserWebService = new RepositoryUserWebImpl(context, this);
        repositoryUserDatabase = new RepositoryUserDatabaseImpl(context, this);


    }

    @Override
    public void getUser() {
        Log.d("PresenterUserImpl","getUser");
        repositoryUserDatabase.getUsers();
        //repositoryUserWenService.getUser();
    }

    @Override
    public void showUserDB(List<User> listUser) {
        Log.d("PresenterUserImpl","showUserDB");
        if (listUser.isEmpty()){
            repositoryUserWebService.getUsers();
        } else {
            viewUser.showUser(listUser);
        }
    }

    @Override
    public void showUserWeb(List<User> listUser) {
        Log.d("PresenterUserImpl","showUserWeb");
        viewUser.showUser(listUser);
        guardarInfoDatabaseUser(listUser);
    }

    @Override
    public void getPostByUserId(String userId) {
    }

    @Override
    public void getAllPost() {
        Log.d("PresenterUserImpl","getAllPost");
        repositoryUserDatabase.getAllPost();
    }

    @Override
    public void showAllPostDB(List<PostUser> postUserList) {
        if (postUserList.isEmpty()){
            repositoryUserWebService.getAllPost();
        }
    }

    @Override
    public void showAllPostWeb(List<PostUser> postUserList) {
        Log.d("PresenterUserImpl","showAllPost");
        guardarInfoDatabasePost(postUserList);
    }

    @Override
    public void showPostByUserIdWeb(List<PostUser> postUserList) {
    }

    @Override
    public void showPostByUserIdDB(List<PostUser> postUserList) {
    }

    @Override
    public void guardarInfoDatabaseUser(List<User> userList) {
        Log.d("PresenterUserImpl","guardarInfoDatabaseUser");
        repositoryUserDatabase.setUser(userList);
    }

    @Override
    public void guardarInfoDatabasePost(List<PostUser> postUserList) {
        Log.d("PresenterUserImpl","guardarInfoDatabasePost");
        repositoryUserDatabase.setAllPost(postUserList);
    }

    @Override
    public void showErrorMessageDialog(int titulo, int mensaje) {
        viewUser.showAlertDialogInf(titulo, mensaje);
    }

    @Override
    public void showErrorMessageDialog(int titulo, String mensaje) {
        viewUser.showAlertDialogInf(titulo, mensaje);
    }

    @Override
    public void cancelarDialogoCargando() {
        viewUser.cancelDialogCargando();
    }

}
