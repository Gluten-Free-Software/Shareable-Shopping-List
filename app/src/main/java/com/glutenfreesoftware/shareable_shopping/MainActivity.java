package com.glutenfreesoftware.shareable_shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button registerUser;
    private Button loginUser;
    private EditText registeredUsernameField;
    private EditText registeredPasswordField;
    private EditText unregisteredUsernameField;
    private EditText unregisteredPasswordField;
    private EditText unregisteredEmailField;
    private EditText unregisteredNameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginUser = (Button) findViewById(R.id.login_existing_user);
        registerUser = (Button) findViewById(R.id.register_unregistered_user);

    }

    /*
    Registers an user to database, does not login.
     */
    public void registerUser(){
        EditText username = (EditText) findViewById(R.id.username_unregistered_user);
        String usernameString = username.getText().toString();
        EditText password = (EditText) findViewById(R.id.password_unregistered_user);
        String passwordString = password.getText().toString();
        EditText email = (EditText) findViewById(R.id.email_unregistered_user);
        String emailString = email.getText().toString();
        EditText name = (EditText) findViewById(R.id.name_unregistered_user);
        String nameString = name.getText().toString();

    }
    /*
    Checks if the user exists. If user exists, logs in and starts a new intent.
     */
    public void loginUser(View v){

        EditText username = (EditText) findViewById(R.id.username_registered_user);
        String usernameString = username.getText().toString();
        EditText password = (EditText) findViewById(R.id.password_registered_user);
        String passwordString = password.getText().toString();

        boolean userExists = true;  // set to true for testing purposes


        if (userExists == true){
            startActivity(new Intent(MainActivity.this, Landing_Activity.class));
        }   else    {
            //Do nothing
        }


    }

}
