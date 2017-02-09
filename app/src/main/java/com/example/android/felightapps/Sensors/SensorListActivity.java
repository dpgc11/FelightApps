package com.example.android.felightapps.Sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.felightapps.R;

import java.util.List;

public class SensorListActivity extends AppCompatActivity {

    private TextView mSensorsTextView;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
        mSensorsTextView = (TextView) findViewById(R.id.tv_sensors_list);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorInfo = new StringBuilder();
        for(Sensor sensor: deviceSensors)
            sensorInfo.append("\n\n" + sensor.getName() + " " + sensor.getType() + " "+ sensor.getVendor());
        mSensorsTextView.setText(sensorInfo.toString());
    }
}
