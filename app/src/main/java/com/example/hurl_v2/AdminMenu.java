package com.example.hurl_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AdminMenu extends AppCompatActivity {

    private CardView admintml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        admintml = (CardView) findViewById(R.id.viewtimeline);

        // codes that logs out user page starts here
        TextView textView41 = findViewById(R.id.textView41);
        textView41.setOnClickListener(view -> {
            Intent intent=new Intent(AdminMenu.this, MainActivity.class);
            startActivity(intent);
        });
        //code that logs out user ends here

        //for going into timeline activity
        admintml.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trans = new Intent(AdminMenu.this, Timeline.class);
                startActivity(trans);
            }
        });

    }
}
