package com.example.hurl_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreatePost extends AppCompatActivity {
    EditText descPost;
    Button post_content;
    Database database = new Database(this);
    SharedPreferences bindData, dataBinder;
    String name,describe;
    TextView fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createpost);

        // codes that goes back to menu page starts here
        TextView textView24 = findViewById(R.id.textView24);
        textView24.setOnClickListener(view -> {
            Intent intent=new Intent(CreatePost.this, MenuActivity.class);
            startActivity(intent);
        });
        //code that goes back to menu page ends here

        //assigning variables to the id
        descPost = findViewById(R.id.add_post_content);
        post_content = findViewById(R.id.add_post_btn);
        fullname = findViewById(R.id.my_fullname2);

        //reading users stored data from the database
        bindData = getSharedPreferences("preference", Context.MODE_PRIVATE);
        dataBinder = getSharedPreferences("preference", MODE_PRIVATE);
        String term1 = dataBinder.getString("fullName", "");
        name = bindData.getString("fullName", "");

        //getting and setting calender date instance
        Calendar calendar = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateformat =new SimpleDateFormat("dd-MM-yyyy");
        String date = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        fullname.setText(term1);

        post_content.setOnClickListener(view -> {
            describe = descPost.getText().toString();
            database.contentAdd(name,describe,date);

            //toast to show post succession message
            Toast.makeText(CreatePost.this, "Post created succesfully !", Toast.LENGTH_SHORT).show();
            Intent toPost = new Intent(CreatePost.this, TimelineActivity.class);
            startActivity(toPost);
        });

    }
}