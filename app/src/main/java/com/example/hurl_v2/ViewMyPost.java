package com.example.hurl_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewMyPost extends AppCompatActivity {
    RecyclerView postSection;
    ArrayList<Timeline> allDatas;
    Database database = new Database(this);
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypost);

        // codes that goes back to menu page starts here
        TextView textView25 = findViewById(R.id.textView25);
        textView25.setOnClickListener(view -> {
            Intent intent=new Intent(ViewMyPost.this, MenuActivity.class);
            startActivity(intent);
        });
        //code that goes back to menu page ends here

        postSection = findViewById(R.id.general_timeline_posts2);
        postSection.setLayoutManager(new LinearLayoutManager(this));
        allDatas = new ArrayList<>(); //shows my post as an array list

        sharedPreferences = getSharedPreferences("preference", MODE_PRIVATE);
        String name = sharedPreferences.getString("fullName", ""); //gets full name for post

        Cursor data = database.myposts(name); //reads my name from the database
        while (data.moveToNext()){
            Timeline object = new Timeline(data.getString(1),data.getString(2),data.getString(3));
            allDatas.add(object);
        }
        //to update my post
        UpdateMyPost adapter = new UpdateMyPost(allDatas);
        postSection.setAdapter(adapter);

    }
}