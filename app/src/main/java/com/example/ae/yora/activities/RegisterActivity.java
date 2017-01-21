package com.example.ae.yora.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ae.yora.R;
import com.example.ae.yora.services.Account;
import com.squareup.otto.Subscribe;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private EditText usernameText;
    private EditText emailText;
    private EditText passwordText;
    private Button registerButton;
    private View progressBar;
    private String defaultRegisterButtonText;

    @Override
    protected void onCreate(Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.activity_register);

        usernameText = (EditText) findViewById(R.id.activity_register_userName);
        emailText = (EditText) findViewById(R.id.activity_register_email);
        passwordText = (EditText) findViewById(R.id.activity_register_password);
        registerButton = (Button) findViewById(R.id.activity_register_registerButton);
        progressBar = findViewById(R.id.activity_register_progressPar);

        defaultRegisterButtonText = registerButton.getText().toString();
        registerButton.setOnClickListener(this);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        if(view == registerButton){
            progressBar.setVisibility(View.VISIBLE);
            registerButton.setText("");
            registerButton.setEnabled(false);
            usernameText.setEnabled(false);
            passwordText.setEnabled(false);
            emailText.setEnabled(false);
           bus.post(new Account.RegisterRequest(
                   usernameText.getText().toString(),
                   emailText.getText().toString(),
                   passwordText.getText().toString()));
        }

    }

    @Subscribe
    public void registerResponse(Account.RegisterResponse response){
        onUserResponse(response);
    }

    @Subscribe
    public void externalRegisterResponse(Account.RegisterWithExternalTokenResponse response){
        onUserResponse(response);
    }

    private void onUserResponse(Account.UserResponse response){
        if(response.didSucced()){
            setResult(RESULT_OK);
            finish();
            return;
        }

        response.showErrorToast(this);
        usernameText.setError(response.getPropretyError("userName"));
        passwordText.setError(response.getPropretyError("password"));
        emailText.setError(response.getPropretyError("email"));


        registerButton.setEnabled(true);
        usernameText.setEnabled(true);
        passwordText.setEnabled(true);
        emailText.setEnabled(true);

        progressBar.setVisibility(View.GONE);
        registerButton.setText(defaultRegisterButtonText);
    }
}
