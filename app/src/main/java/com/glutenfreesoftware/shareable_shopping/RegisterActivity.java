package com.glutenfreesoftware.shareable_shopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button registerUser = (Button) findViewById(R.id.registerbtn);

}

    /*
    Registers an user to database, does not login.
     */
    public void registerUser(){
        EditText username = (EditText) findViewById(R.id.username);
        String usernameString = username.getText().toString();
        EditText password = (EditText) findViewById(R.id.password);
        String passwordString = password.getText().toString();
        EditText email = (EditText) findViewById(R.id.email);
        String emailString = email.getText().toString();
        EditText name = (EditText) findViewById(R.id.name);
        String nameString = name.getText().toString();
        //Put details on server
        registerToServer(usernameString, passwordString, emailString, nameString);

    }

    /**
     * Registers to server
     */
    private void registerToServer(String username, String password, String email, String name) {

    }




}
