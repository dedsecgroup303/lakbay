package com.example.besafeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import static java.lang.Thread.sleep;

public class splashscreen extends AppCompatActivity  {

    ImageView splashimage;
    Sensor mysensor;
    SensorManager mysensormaneger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        splashimage= findViewById(R.id.img);
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.myanimation);
        splashimage.startAnimation(myanim);

        Thread myThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    sleep(3000);

                    Intent intent = new Intent(splashscreen.this,mainmenu.class);
                    startActivity(intent);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        myThread.start();
    }

}
