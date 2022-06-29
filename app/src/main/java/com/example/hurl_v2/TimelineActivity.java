package com.example.hurl_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class TimelineActivity extends AppCompatActivity {
    RecyclerView postSection;
    ArrayList<Timeline> allDatas;
    Database database = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        // codes that goes back to menu page starts here
        TextView textView21 = findViewById(R.id.textView21);
        textView21.setOnClickListener(view -> {
            Intent intent=new Intent(TimelineActivity.this, MenuActivity.class);
            startActivity(intent);
        });
        //code that goes back to menu page ends here

        postSection = findViewById(R.id.general_timeline_posts);
        postSection.setLayoutManager(new LinearLayoutManager(this));
        allDatas = new ArrayList<>(); //shows post as an array list
        Cursor data = database.allPosts(); //cursor to show all posts in the timeline

        while (data.moveToNext()){
            Timeline object = new Timeline(data.getString(1),data.getString(2),data.getString(3));
            allDatas.add(object);
        }

        //initializing adapter to show all posts
        Adapter adapter = new Adapter(allDatas);
        postSection.setAdapter(adapter);
    }
}