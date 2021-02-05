package co.com.ceiba.mobile.pruebadeingreso.MVP.Presenter;

import android.content.Context;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.RepositoryUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.RepositoryUserImpl;
import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.User;
import co.com.ceiba.mobile.pruebadeingreso.MVP.View.ViewUser;

public class PresenterUserImpl implements PresenterUser{

    ViewUser viewUser;
    RepositoryUser repositoryUser;

    public PresenterUserImpl(ViewUser viewUser, Context context) {
        this.viewUser = viewUser;
        repositoryUser = new RepositoryUserImpl(context, this);

    }

    @Override
    public void getUser() {

        repositoryUser.getUserFromWebServices();
    }

    @Override
    public void showUser(List<User> listUser) {
        viewUser.showUser(listUser);
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

    @Override
    public void getPostUserId(String userId) {

    }

    @Override
    public void getAllPost() {
        repositoryUser.getAllPostWebService();
    }
}
