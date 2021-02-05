package co.com.ceiba.mobile.pruebadeingreso.MVP.View;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.Modelo.PostUser;

public interface ViewPost extends ViewGeneral{
    void getPostUserId(String userId);

    void getAllPost();

    void showPostByUser(List<PostUser> postUsers);
}
