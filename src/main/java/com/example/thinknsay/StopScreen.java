package com.example.thinknsay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StopScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_screen);

        Button butt_chkdata = findViewById(R.id.butt_data);
        butt_chkdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openIntent = new Intent(StopScreen.this, testdatabase.class);
                startActivity(openIntent);
            }
        });

        Button butt_resume = findViewById(R.id.butt_resume);
        butt_resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resumeIntent = new Intent(StopScreen.this,PlayScreen.class);
                startActivity(resumeIntent);
            }
        });

        Button butt_restart = findViewById(R.id.butt_restart);
        butt_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restartIntent = new Intent(StopScreen.this,PlayScreen.class);
                startActivity(restartIntent);
            }
        });

        Button butt_menu = findViewById(R.id.butt_menu);
        butt_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(StopScreen.this,MainActivity.class);
                startActivity(menuIntent);
            }
        });
    }
}
