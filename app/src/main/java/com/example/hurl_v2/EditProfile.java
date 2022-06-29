package com.example.hurl_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {

    private EditText uname, fname, email,password; //private variables

    Button savechangebtn;
    SharedPreferences dataBinder;
    Database database = new Database(this);
    String username, fullname, emailaddress, _userid, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        // codes that goes back to sign in page starts here
        TextView textView23 = findViewById(R.id.textView23);
        textView23.setOnClickListener(view -> {
            Intent intent=new Intent(EditProfile.this, ProfileActivity.class);
            startActivity(intent);
        });
        //code that goes back to sign in page ends here

        //assigning variables to the id
        uname = findViewById(R.id.edit_username);
        fname = findViewById(R.id.edit_fullname);
        email = findViewById(R.id.edit_email);
        password = findViewById(R.id.edit_password);
        savechangebtn = findViewById(R.id.edit_savebtn);

        //gets the declared shared preferences
        dataBinder = getSharedPreferences("preference", Context.MODE_PRIVATE);
        uname.setText(dataBinder.getString("userName", ""));
        fname.setText(dataBinder.getString("fullName", ""));
        email.setText(dataBinder.getString("mail", ""));
        password.setText(dataBinder.getString("pass", ""));
        _userid = dataBinder.getString("user_id", "");

        //getting string data in the text field when updating user profile
        savechangebtn.setOnClickListener(view -> {
            username = uname.getText().toString();
            fullname = fname.getText().toString();
            emailaddress = email.getText().toString();
            pass = password.getText().toString();
            Log.i("updateid", _userid);

            //databinder to apply data into test fields
            dataBinder.edit().putString("userName", username).apply();
            dataBinder.edit().putString("fullName", fullname).apply();
            dataBinder.edit().putString("mail", emailaddress).apply();
            dataBinder.edit().putString("password", pass).apply();

            //will update new changes in the database
            database.updateIndividual(username, fullname, emailaddress,pass, _userid);
            Toast.makeText(EditProfile.this, "Profile Updated !", Toast.LENGTH_SHORT).show();
            Intent throwToProfile = new Intent(EditProfile.this, ProfileActivity.class);
            startActivity(throwToProfile);
        });
    }
}