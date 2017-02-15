package com.example.android.felightapps.ListViewDemo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.felightapps.R;

import java.util.ArrayList;
import java.util.List;

public class SensorsListViewActivity extends AppCompatActivity {

    private ListView mSensorsListListView;
    private List<Sensor> mSensorsList;
    private SensorManager mSensorManager;
    private List<Integer> mSensorTypeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors_list_view);

        mSensorsListListView = (ListView) findViewById(R.id.lv_sensors_list);
        mSensorsList = new ArrayList<>();
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorsList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        mSensorTypeList = new ArrayList<>();
        for (Sensor s : mSensorsList) {
            mSensorTypeList.add(s.getType());
        }

        ArrayAdapter<Integer> SensorAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, mSensorTypeList);
        mSensorsListListView.setAdapter(SensorAdapter);

        mSensorsListListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Sensor currentSensor = mSensorsList.get(i);
                String selected = "Vendor: " + currentSensor.getVendor() + "\nName: " + currentSensor.getName() + "\nPower: " + currentSensor.getPower();
                Toast.makeText(getApplicationContext(),  selected , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
