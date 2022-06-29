package com.example.hurl_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView adminpanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // codes that goto login in page
        button= findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this, SignIn.class);
            startActivity(intent);
        });
        //code that goto login in page ends here

        // codes that goto admin panel starts here
        adminpanel= findViewById(R.id.admin);
        adminpanel.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this, AdminLogin.class);
            startActivity(intent);
        });
        //code that goto admin panel ends here
    }
}