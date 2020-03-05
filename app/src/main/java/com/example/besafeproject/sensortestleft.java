package com.example.besafeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class sensortestleft extends AppCompatActivity implements SensorEventListener{


    Sensor mysensor;
    SensorManager mysensormaneger;
    TextView x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensortestleft);


        // create sensor manager
        mysensormaneger=(SensorManager)getSystemService(SENSOR_SERVICE);
        //Acceleremeter Sensor
        mysensor=mysensormaneger.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mysensormaneger.registerListener(this,mysensor,SensorManager.SENSOR_DELAY_NORMAL);

        x = findViewById(R.id.x);

//

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float string = sensorEvent.values[0];
        x.setText("X: "+ sensorEvent.values[0]);

        if(string > 9.000){
//
            Intent p = new Intent(sensortestleft.this,warning.class);
            startActivity(p);


        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
