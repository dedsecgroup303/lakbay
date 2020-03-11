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

import java.util.jar.Manifest;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    ImageView splashimage;
    Sensor mysensor;
    SensorManager mysensormaneger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashimage= findViewById(R.id.img);

        mysensormaneger = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (mysensormaneger.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            // success! we have an accelerometer

            mysensor = mysensormaneger.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            mysensormaneger.registerListener(this, mysensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            finish();
            System.exit(0);
        }



        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.myanimation);
        splashimage.startAnimation(myanim);

        Thread myThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    sleep(3000);

                    Intent intent = new Intent(MainActivity.this,login.class);
                    startActivity(intent);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        myThread.start();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
