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

/**
 * Created by Yogesh on 09-02-2017.
 */

public class SensorMagneticFieldValuesActivity extends AppCompatActivity implements SensorEventListener {

    private Sensor mMagneticFieldSensor;
    private SensorManager mSensorManager;
    private TextView mSensorMagenticFieldAttributesTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_magnetic_field_values);

        mSensorMagenticFieldAttributesTextView = (TextView) findViewById(R.id.tv_sensor_magnetic_field_attributes);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mMagneticFieldSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];
        mSensorMagenticFieldAttributesTextView.setText("Magnetic Field Attributes: \n\n" + "X: "+ x + "\nY: "+ y +"\nZ: " +z);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mMagneticFieldSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
