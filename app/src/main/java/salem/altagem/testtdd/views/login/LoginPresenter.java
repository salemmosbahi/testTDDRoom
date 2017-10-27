package salem.altagem.testtdd.views.login;

import salem.altagem.testtdd.db.Database;
import salem.altagem.testtdd.entity.User;

/**
 * Created by salem on 10/15/17.
 */

public class LoginPresenter {
    private LoginView loginView;
    private int iLoginAttemptMax = 3;
    private int loginAttempt;
    private Database db = null;

    public LoginPresenter(LoginView pLoginView) {
        loginView = pLoginView;
        db = Database.getInstanceDB(pLoginView.getApplicationContext());
    }

    public void login(String pUsername, String pPassword) {
        if (isLoginAttemptExceeded()) {
            loginView.showErrorMessageForMaxLoginAttempt();
            return;
        }
        User user = db.userDao().login(pUsername, pPassword);
        if (null != user) {
            if (!user.username().isEmpty()) {
                loginView.showSuccessMessage();
                resetLoginAttempt();
                return;
            }
        }
        /*if ("salem".equals(pUsername) && "salem".equals(pPassword)) {
            loginView.showSuccessMessage();
            resetLoginAttempt();
            return;
        }*/
        incrementLoginAttempt();
        loginView.showErrorMessageForUsernameOrPassword();
    }

    public int incrementLoginAttempt() {
        return ++loginAttempt;
    }

    public void resetLoginAttempt() {
        loginAttempt = 0;
    }

    public boolean isLoginAttemptExceeded() {
        return loginAttempt >= iLoginAttemptMax;
    }
}
