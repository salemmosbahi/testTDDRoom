package salem.altagem.testtdd.views.login;

/**
 * Created by salem on 10/15/17.
 */

public interface LoginModel {
    void showErrorMessageForUsernameOrPassword();
    void showErrorMessageForMaxLoginAttempt();
    void showSuccessMessage();
}
