package com.example.hurl_v2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MenuActivity extends AppCompatActivity {

    private CardView profile, timeline, post, viewmypost; //declaring private variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // codes that logs out user page starts here
        TextView textView29 = findViewById(R.id.textView29);
        textView29.setOnClickListener(view -> {
            Intent intent=new Intent(MenuActivity.this, MainActivity.class);
            startActivity(intent);
        });
        //code that logs out user ends here

        //assigning variables to the id
        profile = findViewById(R.id.profile);
        timeline = findViewById(R.id.timeline);
        post = findViewById(R.id.cpost);
        viewmypost = findViewById(R.id.mypost);

        Intent intent = getIntent();
        String name = intent.getStringExtra("username");

        //for going into profile activity
        profile.setOnClickListener(v -> {
            Intent trans = new Intent(MenuActivity.this, ProfileActivity.class);
            trans.putExtra("username",name);
            startActivity(trans);
        });

        //for going into timeline activity
        timeline.setOnClickListener(v -> {
            Intent trans = new Intent(MenuActivity.this, TimelineActivity.class);
            startActivity(trans);
        });

        //for going into create post activity
        post.setOnClickListener(v -> {
            Intent trans = new Intent(MenuActivity.this, CreatePost.class);
            startActivity(trans);
        });

        //for going into my post activity
        viewmypost.setOnClickListener(v -> {
            Intent trans = new Intent(MenuActivity.this, ViewMyPost.class);
            startActivity(trans);
        });
    }
}