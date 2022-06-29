package com.example.hurl_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class SignIn extends AppCompatActivity {

    //assigning id to widget
    EditText suname,mainPassword;
    Button slogin;
    TextView fregister;
    Database database = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        //assigning variables to the id
        fregister = findViewById(R.id.signin_createaccount);
        slogin = findViewById(R.id.signin_loginbtn);
        suname = findViewById(R.id.signin_enterusername);
        mainPassword = findViewById(R.id.signin_enterpassword);

        SharedPreferences preferences = getSharedPreferences("preference", MODE_PRIVATE);

        if (!Objects.equals(preferences.getString("username", ""), "") && !Objects.equals(preferences.getString("password", ""), "")) { // code to understand
            Intent intent = new Intent(SignIn.this, MenuActivity.class);
            startActivity(intent);
        }

        slogin.setOnClickListener(view -> {
            String username = suname.getText().toString();
            String password = mainPassword.getText().toString();
            Cursor checkUser = database.loginCheck(username, password); //checks users username and password from the database

            //checking users record from the database
            if (checkUser.moveToFirst()) {
                do {
                    int userName = checkUser.getColumnIndex("username");
                    int fullName = checkUser.getColumnIndex("fullname");
                    int mail = checkUser.getColumnIndex("email");
                    int passcode = checkUser.getColumnIndex("password");
                    int dayRegister = checkUser.getColumnIndex("day");
                    int id = checkUser.getColumnIndex("individual_id");

                    SharedPreferences preferences1 = getSharedPreferences("preference", MODE_PRIVATE);
                    preferences1.edit().putString("userName", checkUser.getString(userName)).apply();
                    preferences1.edit().putString("fullName", checkUser.getString(fullName)).apply();
                    preferences1.edit().putString("mail", checkUser.getString(mail)).apply();
                    preferences1.edit().putString("passcode", checkUser.getString(passcode)).apply();
                    preferences1.edit().putString("day_Register", checkUser.getString(dayRegister)).apply();
                    preferences1.edit().putString("user_id", checkUser.getString(id)).apply();

                } while (checkUser.moveToNext()); //moves to next after completing first step
            }

          //function to check login parameter
            boolean check = checkUser.getCount()>0;
           if (check == true){
               Toast.makeText(SignIn.this, "logged in Successfully!", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(SignIn.this, MenuActivity.class);
               startActivity(intent);
           }
           else {
               Toast.makeText(SignIn.this, "Invalid username or password!", Toast.LENGTH_SHORT).show();
           }
        });

        //goes to register page if new user
        fregister.setOnClickListener(view -> {
            Intent intent = new Intent(SignIn.this, SignUp.class);
            startActivity(intent);
        });
    }
}