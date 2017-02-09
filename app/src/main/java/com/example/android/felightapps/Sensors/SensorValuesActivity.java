package com.example.android.felightapps.Sensors;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.felightapps.R;

/**
 * Created by Yogesh on 09-02-2017.
 */

public class SensorValuesActivity extends AppCompatActivity{

    private Button mAccelerometerValuesButton;
    private Button mMagneticFieldValuesButton;
    private Button mGravityValuesButton;
    private Button mShakeDetectButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_values);

        mAccelerometerValuesButton = (Button) findViewById(R.id.sensor_accelerometer_values_activity);
        mMagneticFieldValuesButton = (Button) findViewById(R.id.sensor_magnetic_field_values_activity);
        mGravityValuesButton = (Button) findViewById(R.id.sensor_gravity_values_activity);
        mShakeDetectButton = (Button) findViewById(R.id.sensor_shake_detect_activity);

        mAccelerometerValuesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SensorValuesActivity.this, SensorAccelerometerValuesActivity.class);
                startActivity(i);
            }
        });

        mMagneticFieldValuesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SensorValuesActivity.this, SensorMagneticFieldValuesActivity.class);
                startActivity(i);
            }
        });

        mGravityValuesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SensorValuesActivity.this, SensorGravityValuesActivity.class);
                startActivity(i);
            }
        });

        mShakeDetectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SensorValuesActivity.this, SensorShakeActivity.class);
                startActivity(i);
            }
        });


    }
}
