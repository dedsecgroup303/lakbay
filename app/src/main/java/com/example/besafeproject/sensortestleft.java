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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensortestleft);


        // create sensor manager
        mysensormaneger=(SensorManager)getSystemService(SENSOR_SERVICE);


        //Acceleremeter Sensor
        mysensor=mysensormaneger.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mysensormaneger.registerListener(this,mysensor,SensorManager.SENSOR_DELAY_NORMAL);

//

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float string = sensorEvent.values[0];
//        textViewX.setText("X: "+ sensorEvent.values[0]);

        if((string > 9.555)){
//            AlertDialog.Builder alert = new AlertDialog.Builder(this);
//            alert.setMessage("goodbye");
//            alert.show();

            Intent p = new Intent(sensortestleft.this,sensortestright.class);
            startActivity(p);


        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
