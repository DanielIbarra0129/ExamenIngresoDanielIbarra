package co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.repositories.repositoryUser;

import android.content.Context;
import android.util.Log;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.DAO.database.databasePost.PostDB;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.DAO.database.databaseUser.UserDB;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis.PostUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis.User;
import co.com.ceiba.mobile.pruebadeingreso.MVP.presenter.PresenterUser;

public class RepositoryUserDatabaseImpl implements RepositoryUser {

    private PresenterUser presenterUser;
    private UserDB userDB;
    private PostDB postDB;

    public RepositoryUserDatabaseImpl(Context context, PresenterUser presenterUser) {
        this.presenterUser = presenterUser;
        userDB = UserDB.getInstance(context);
        postDB = PostDB.getInstance(context);
    }
    /**
     * DEVOLVEMOS VALORES NULOS SIMULANDO QUE DB NO TIENE REGISTROS
     * **/

    @Override
    public void getUsers() {
        Log.d("RepositoryUserDBImpl","getUser");

        List<User> userList;
        userList = userDB.getUser();
        presenterUser.showUserDB(userList);

    }

    @Override
    public void setUser(List<User> userList) {
        Log.d("RepositoryUserDBImpl","setUser");
        for (int i=0; i<userList.size(); i++){
            userDB.setUser(userList.get(i));
        }
    }

    @Override
    public void getPostUserId(String userId) {
       postDB.getPostById(userId);
    }

    @Override
    public void getAllPost() {
        presenterUser.showAllPostDB(postDB.getPost());
    }

    @Override
    public void setAllPost(List<PostUser> listPost) {
        for (PostUser postUser : listPost){
            postDB.setPost(postUser);
        }
    }

    @Override
    public boolean verificarConexion() {
        return false;
    }
}
