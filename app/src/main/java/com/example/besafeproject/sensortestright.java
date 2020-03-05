package com.example.besafeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class sensortestright extends AppCompatActivity implements SensorEventListener {

    Sensor ms;
    SensorManager msm;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensortestright);

        // create sensor manager
        msm=(SensorManager)getSystemService(SENSOR_SERVICE);


        //Acceleremeter Sensor
        ms=msm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        msm.registerListener(this,ms,SensorManager.SENSOR_DELAY_NORMAL);

        textView=findViewById(R.id.t);

//

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float stringg = sensorEvent.values[0];
      textView.setText("X: "+ sensorEvent.values[0]);

        if(stringg < -9.000){
//

            Intent k = new Intent(sensortestright.this,warningtwo.class);
            startActivity(k);


        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
