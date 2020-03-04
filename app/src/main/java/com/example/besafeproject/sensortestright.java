package com.example.besafeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class sensortestright extends AppCompatActivity implements SensorEventListener {

    Sensor ms;
    SensorManager msm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensortestright);

        // create sensor manager
        msm=(SensorManager)getSystemService(SENSOR_SERVICE);


        //Acceleremeter Sensor
        ms=msm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        msm.registerListener(this,ms,SensorManager.SENSOR_DELAY_NORMAL);

//

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float string = sensorEvent.values[0];
//        textViewX.setText("X: "+ sensorEvent.values[0]);

        if((string > -9.555)){
//            AlertDialog.Builder alert = new AlertDialog.Builder(this);
//            alert.setMessage("goodbye");
//            alert.show();

            Intent p = new Intent(sensortestright.this,warning.class);
            startActivity(p);


        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
