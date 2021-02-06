package co.com.ceiba.mobile.pruebadeingreso.MVP.presenter;

import android.content.Context;
import android.util.Log;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.PostUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.RepositoryUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.RepositoryUserDatabaseImpl;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.RepositoryUserWebImpl;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.User;
import co.com.ceiba.mobile.pruebadeingreso.MVP.view.ViewUser;

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
        repositoryUserDatabase.getUsers();
    }

    @Override
    public void showUserDB(List<User> listUser) {
        if (listUser.isEmpty()){
            repositoryUserWebService.getUsers();
        } else {
            viewUser.showUser(listUser);
        }
    }

    @Override
    public void showUserWeb(List<User> listUser) {
        viewUser.showUser(listUser);
        guardarInfoDatabaseUser(listUser);
    }

    @Override
    public void getPostByUserId(String userId) {
    }

    @Override
    public void getAllPost() {
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
        repositoryUserDatabase.setUser(userList);
    }

    @Override
    public void guardarInfoDatabasePost(List<PostUser> postUserList) {
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
