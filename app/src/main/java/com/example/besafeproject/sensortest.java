package com.example.besafeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

public class sensortest extends AppCompatActivity implements SensorEventListener {

    Sensor mysensor;
    SensorManager mysensormaneger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensortest);

        mysensormaneger = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (mysensormaneger.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            // success! we have an accelerometer

            mysensor = mysensormaneger.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            mysensormaneger.registerListener(this, mysensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            finish();
            System.exit(0);
        }


        //Register sensor listener
//        mysensormaneger.registerListener(this,mysensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        double x = sensorEvent.values[0];

        double vector = Math.sqrt(x*x);

        if(vector >= 10) {
            Toast.makeText(this, "your sensor is fine", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mysensormaneger.registerListener(this, mysensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mysensormaneger.unregisterListener(this);
    }
}
