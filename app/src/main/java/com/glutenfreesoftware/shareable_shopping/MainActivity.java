package com.glutenfreesoftware.shareable_shopping;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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
        //Put details on server
        registerToServer();

    }

    /**
     * Regsisters to server
     */
    private void registerToServer() {

    }

    /*
    Checks if the user exists. If user exists, logs in and starts a new intent.
     */
    public void loginUser(View v){
        EditText username = (EditText) findViewById(R.id.username_registered_user);
        String usernameString = username.getText().toString();
        EditText password = (EditText) findViewById(R.id.password_registered_user);
        String passwordString = password.getText().toString();

        checkLogin(v,usernameString,passwordString);
    }

    public void checkLogin(View view, String usernameInput, String passwordInput){

        final String username = usernameInput;
        final String password = passwordInput;

        if(!username.equals("") && !password.equals("")){
            //System.out.println("It works! OMG");
            try {
                new LoginCheck(new LoginCheck.OnPostExecute() {
                    @Override
                    public void onPostExecute(List<Users> users) {
                        if(users.isEmpty()){
                            //System.out.println("No match in the database");
                        }
                        for(Users u : users) {
                            System.out.println("User: " + u.getUsername());
                            if(username.equals(u.getUsername())){
                                //System.out.println("We have a match in the database");
                                Intent intent = new Intent(MainActivity.this, Landing_Activity.class);
                                intent.putExtra("username", u.getUsername());
                                startActivity(intent);
                            }
                        }
                    }
                }).execute(new URL("http://192.168.1.43:8080/ChatApplicationGit/api/users/getUser?username=" + username)); //(new url.("http://158.38.92.103:8080/pstore/api/store/images/"));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

}
