package com.example.thinknsay;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class PlayScreen extends AppCompatActivity {

    CountDownTimer countDownTimer;
    TextView textTime;

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000 ;
    TextView mTextTV;
    ImageButton mVoiceBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);

        mTextTV = findViewById(R.id.textTv);
        mVoiceBtn = findViewById(R.id.butt_mic);

        mVoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                speak();

            }
        });

        //Pause Button

        ImageButton pause_button = findViewById(R.id.butt_pause);
        pause_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseGame();
            }
        });

//        Button butt_data = findViewById(R.id.butt_data);
//        butt_data.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(PlayScreen.this,testdatabase.class);
//                startActivity(intent);
//            }
//        });


        //countdown time
        textTime = findViewById(R.id.timer);

        //timer
        countDownTimer = new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //Toast.makeText(MainActivity.this,"START", Toast.LENGTH_LONG).show();
                textTime.setText(millisUntilFinished/1000+ "s");
            }

            @Override
            public void onFinish() {
                textTime.setText("Time's Up");
                //Toast.makeText(MainActivity.this, "Time's Up", Toast.LENGTH_SHORT).show();
            }
        };

    }

    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi speak something");

        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
        }
        catch (Exception e){
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQUEST_CODE_SPEECH_INPUT:{
                if (resultCode == RESULT_OK && null!=data){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mTextTV.setText(result.get(0));
                }
                break;
            }
        }
    }

    public void pauseGame(){
        Intent intent = new Intent(this, StopScreen.class);
        startActivity(intent);
    }
}
