package com.example.android.felightapps.Sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.felightapps.R;

public class SensorAccelerometerValuesActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometerSensor;

    private TextView mSensorAccelerometerAttributesTextView;
    private static final int SHAKE_THRESHOLD = 800;
    private long lastUpdate;
    private float x;
    private float y;
    private float z;
    private float last_x;
    private float last_y;
    private float last_z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_accelerometer_values);
        mSensorAccelerometerAttributesTextView = (TextView) findViewById(R.id.tv_sensor_accelerometer_attributes);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometerSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
// The light mAccelerometerSensor returns a single value.
// Many sensors return 3 values, one for each axis.
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];
        mSensorAccelerometerAttributesTextView.setText("Accelerometer Attributes: \n\n" + "X: " + x + "\nY: " + y + "\nZ: " + z);
// Do something with this mAccelerometerSensor value.
/* long curTime = System.currentTimeMillis();
// only allow one update every 100ms.
if ((curTime – lastUpdate) > 100) {
long diffTime = (curTime – lastUpdate);
lastUpdate = curTime;
x = sensorEvent.values[0];
y = sensorEvent.values[1];
z = sensorEvent.values[2];
float speed = Math.abs(x+y+z – last_x – last_y – last_z) / diffTime * 10000;
if (speed > SHAKE_THRESHOLD) {
Log.d(“mAccelerometerSensor”, “shake detected w/ speed: ” + speed);
mSensorAccelerometerAttributesTextView.setText(“shake detected w/ speed: ” + speed);
}
last_x = x;
last_y = y;
last_z = z;
}
*/
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
