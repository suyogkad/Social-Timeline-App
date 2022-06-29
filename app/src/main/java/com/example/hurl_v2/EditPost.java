package com.example.hurl_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class EditPost extends AppCompatActivity {

    Database database = new Database(this);
    SharedPreferences bindData, dataBinder;
    String name;
    TextView fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);

        fullname = findViewById(R.id.my_fullname3);

        String term1 = dataBinder.getString("fullName", "");
        name = bindData.getString("fullName", "");

        fullname.setText(term1);


    }
}