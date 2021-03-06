package com.engineersdream.ed_accelerometer_sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
Sensor accelsensor;
    TextView text;
    SensorManager sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    sm =(SensorManager) getSystemService(SENSOR_SERVICE);
        accelsensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sm.registerListener(this,accelsensor,SensorManager.SENSOR_DELAY_NORMAL);

        text = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
text.setText("\nX: "+event.values[0] +
             "\nY: "+event.values[1] +
             "\nZ: "+event.values[2] );
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
