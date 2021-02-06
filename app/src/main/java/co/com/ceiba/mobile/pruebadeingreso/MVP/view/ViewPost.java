package co.com.ceiba.mobile.pruebadeingreso.MVP.view;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.PostUser;

public interface ViewPost extends ViewGeneral{
    void getPostUserId(String userId);

    void getAllPost();

    void showPostByUser(List<PostUser> postUsers);
}
