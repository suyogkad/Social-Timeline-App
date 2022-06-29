package com.example.hurl_v2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminLogin extends AppCompatActivity {

    //declaring private variables
    private EditText username, password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        // codes that goes back to start page starts here
        TextView textView27 = findViewById(R.id.textView27);
        textView27.setOnClickListener(view -> {
            Intent intent=new Intent(AdminLogin.this, MainActivity.class);
            startActivity(intent);
        });
        //code that goes back to start page ends here
        //assigning variables to their id
        username = findViewById(R.id.editTextTextPassword);
        password = findViewById(R.id.editTextTextPassword2);
        button = findViewById(R.id.button3);
    }

    public void nextPage(View view) {
        EditText username = findViewById(R.id.editTextTextPassword);
        EditText password = findViewById(R.id.editTextTextPassword2);


        //assigning multiple username and password for login
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {

        }
            Intent intent = new Intent(AdminLogin.this, AdminMenu.class); //code that goes to profile acitivity
            intent.putExtra("keyname", username.getText().toString());  //assigns text as string of name
            intent.putExtra("keypassword", password.getText().toString()); //assigns text as string of passsword
            startActivity(intent);

        }
}
