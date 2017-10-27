package salem.altagem.testtdd.views.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import salem.altagem.testtdd.R;

/**
 * Created by salem on 10/15/17.
 */

public class LoginView extends AppCompatActivity implements LoginModel {
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initializePresenter();
        initializeViews();
    }

    private void initializePresenter() {
        loginPresenter = new LoginPresenter(this);
    }

    private void initializeViews() {
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login(etUsername.getText().toString().trim(),
                        etPassword.getText().toString().trim());
            }
        });
    }

    @Override
    public void showErrorMessageForUsernameOrPassword() {
        Toast.makeText(getApplication(), R.string.showErrorMessageForUsernameOrPassword, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessageForMaxLoginAttempt() {
        Toast.makeText(getApplication(), R.string.showErrorMessageForMaxLoginAttempt, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessMessage() {
        Toast.makeText(getApplication(), R.string.showSuccessMessage, Toast.LENGTH_SHORT).show();
    }
}
