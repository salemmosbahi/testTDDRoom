package salem.altagem.testtdd.views.login;

import org.junit.Assert;
import org.junit.Test;

import salem.altagem.testtdd.views.login.login.LoginPresenter;
import salem.altagem.testtdd.views.login.login.LoginView;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by salem on 10/15/17.
 */

public class LoginPresenterTest {
    @Test
    public void shouldIfLoginAttemptExceeded() {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        Assert.assertEquals(1, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(2, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(3, loginPresenter.incrementLoginAttempt());
        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded());
    }

    @Test
    public void shouldIfLoginAttemptNotExceeded() {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        Assert.assertFalse(loginPresenter.isLoginAttemptExceeded());
    }

    @Test
    public void shouldUsernameAndPasswordCorrect() {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.login("salem","salem");
        verify(loginView).showSuccessMessage();
    }

    @Test
    public void shouldUsernameAndPasswordNotCorrect() {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.login("sabrine","sabrine");
        verify(loginView).showErrorMessageForUsernameOrPassword();
    }

    @Test
    public void shouldIfLoginAttemptExceededMethodCalled() {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.login("ihsen","web");
        loginPresenter.login("salem","web");
        loginPresenter.login("sami","web");
        verify(loginView).showErrorMessageForMaxLoginAttempt();
    }
}
