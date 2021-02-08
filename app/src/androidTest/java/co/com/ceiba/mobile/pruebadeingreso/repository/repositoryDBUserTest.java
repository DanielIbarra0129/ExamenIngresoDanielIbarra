package co.com.ceiba.mobile.pruebadeingreso.repository;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.entitis.User;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.repositories.repositoryUser.RepositoryUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.modelo.repositories.repositoryUser.RepositoryUserDatabaseImpl;
import co.com.ceiba.mobile.pruebadeingreso.MVP.presenter.PresenterUser;
import co.com.ceiba.mobile.pruebadeingreso.MVP.presenter.PresenterUserImpl;
import co.com.ceiba.mobile.pruebadeingreso.MVP.view.ViewUser;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

@RunWith(MockitoJUnitRunner.class)
public class repositoryDBUserTest {

    RepositoryUser repositoryUser;

    @Mock
    PresenterUser presenterUser;

    @Mock
    ViewUser viewUser;

    Context context;

    private List<User> listUser;

    @Before
    public void init () {
        listUser=new ArrayList<>();
        context = InstrumentationRegistry.getTargetContext();
        repositoryUser = new RepositoryUserDatabaseImpl(context, presenterUser);


    }

    @Test
    public void verificarListaDB () {
        repositoryUser.getUsers();
        verify(repositoryUser.getUserSaved()).isEmpty();
    }
}
