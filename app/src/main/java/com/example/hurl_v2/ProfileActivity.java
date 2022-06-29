package com.example.hurl_v2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView username, fullname,email, dateregistered, fname;
    Button updateprofbtn;
    SharedPreferences dataBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // codes that goes back to menu page starts here
        TextView textView22 = findViewById(R.id.textView22);
        textView22.setOnClickListener(view -> {
            Intent intent=new Intent(ProfileActivity.this, MenuActivity.class);
            startActivity(intent);
        });
        //code that goes back to menu page ends here

        //assigning variable to their id
        username = findViewById(R.id.my_username);
        fname = findViewById(R.id.my_fname4);
        fullname = findViewById(R.id.my_fullname);
        email = findViewById(R.id.my_email);
        dateregistered = findViewById(R.id.my_day_register);
        updateprofbtn = findViewById(R.id.my_profile_update);

        dataBinder = getSharedPreferences("preference", MODE_PRIVATE);
        String term1 = dataBinder.getString("userName", "");
        String term2 = dataBinder.getString("fullName", "");
        String term4 = dataBinder.getString("mail", "");
        String term5 = dataBinder.getString("day_Register", "");

        //sets users data into text field
        username.setText(term1);
        fname.setText(term2);
        fullname.setText(term2);
        email.setText(term4);
        dateregistered.setText(term5);

        //will goto profile page after updating new changes
        updateprofbtn.setOnClickListener(view -> {
            Intent changeProfile = new Intent(ProfileActivity.this, EditProfile.class);
            startActivity(changeProfile);
        });
    }
}