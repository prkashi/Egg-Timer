package com.example.punithrkashi.eggtimer;

import android.os.CountDownTimer;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView timertextview;
    SeekBar timeseekbar;
    Boolean counteractive = false;

    public void updateTimer(int secondsLeft){

        int minutes = (int) secondsLeft / 60;
        int seconds = secondsLeft - (minutes * 60);
        String secondString = "0";

        if(seconds < 9){

            secondString = "0" + secondString;

        }

        timertextview.setText(Integer.toString(minutes) + ":" + secondString);

    }


    public void controlTimer(View view){
        

        new CountDownTimer(timeseekbar.getProgress() * 1000 + 100 ,1000) {
            @Override
            public void onTick(long l) {

                updateTimer((int)l / 1000);

            }

            @Override
            public void onFinish() {

                timertextview.setText("0:00");

                Log.i("finsih", "finish");

            }
        }.start();



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeseekbar = (SeekBar) findViewById(R.id.timerSeekBar);
        timertextview = (TextView) findViewById(R.id.time);

        timeseekbar.setMax(600);
        timeseekbar.setProgress(30);

        timeseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
