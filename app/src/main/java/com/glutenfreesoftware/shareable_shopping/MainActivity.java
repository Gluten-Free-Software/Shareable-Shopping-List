package com.glutenfreesoftware.shareable_shopping;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginUser = (Button) findViewById(R.id.login_existing_user);
        registerUser = (Button) findViewById(R.id.register_user);



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

        /*if(!username.equals("") && !password.equals("")){
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
                    }//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
                }).execute(new URL("http://158.38.195.109:8080/Shareable-Shopping-List-REST/api/users/getUser?username=" + username)); //(new url.("http://158.38.92.103:8080/pstore/api/store/images/"));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }*/
        Intent intent = new Intent(MainActivity.this, Landing_Activity.class);
        intent.putExtra("username", usernameInput);
        startActivity(intent);
    }



    public void openRegistrationActivity(View v){
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

}
