package com.example.hurl_v2;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SignUp extends AppCompatActivity {
    EditText registeruname, registerfname, registeremail, registerpass;
    Button registerbtn;
    String uname, fname,email, pass;
    Database database = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        registeruname = findViewById(R.id.signup_enterusername);
        registerfname = findViewById(R.id.signup_enterfullname);
        registeremail = findViewById(R.id.signup_enteremail);
        registerpass = findViewById(R.id.signup_enterpassword);
        registerbtn = findViewById(R.id.signup_registerbtn);

        // codes that goes back to signin page starts here
        TextView textView3 = findViewById(R.id.signin_unameview);
        textView3.setOnClickListener(view -> {
            Intent intent=new Intent(SignUp.this, SignIn.class);
            startActivity(intent);
        });
        //code that goes back to signin page ends here

        //to get date instance
        Calendar calendar = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateformat =new SimpleDateFormat("dd-MM-yyyy");
        String date = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        registerbtn.setOnClickListener(view -> {
            uname = registeruname.getText().toString();
            fname = registerfname.getText().toString();
            email = registeremail.getText().toString();
            pass = registerpass.getText().toString();

            //function that checks the login parameter
            if (uname.equals("")|| fname.equals("")||email.equals("")|| pass.equals("")) {
                Toast.makeText(SignUp.this, "Please enter all fields.", Toast.LENGTH_SHORT).show();
            }
            else
            {
                database.insertData(uname, fname,email, pass,date);
                Toast.makeText(SignUp.this, "Thank you for registering, "+ fname, Toast.LENGTH_SHORT).show();
            }

            });
        }
    }
