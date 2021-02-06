package co.com.ceiba.mobile.pruebadeingreso.MVP.presenter;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.PostUser;

public interface PresenterPost extends PresenterGeneral{
    void getPostByUserId(String userId);

    void getAllPost();

    void showAllPostWeb(List<PostUser> postUserList);

    void showAllPostDB(List<PostUser> postUserList);

    void showPostByUserIdWeb(List<PostUser> postUserList);

    void showPostByUserIdDB(List<PostUser> postUserList);

    void guardarInfoDatabasePost(List<PostUser> postUserList);
}
