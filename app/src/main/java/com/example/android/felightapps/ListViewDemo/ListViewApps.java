package com.example.android.felightapps.ListViewDemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.felightapps.R;

/**
 * Created by Yogesh on 10-02-2017.
 */

public class ListViewApps extends AppCompatActivity {

    private Button mListViewDemoButton;
    private Button mSensorsListButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_apps);
        mListViewDemoButton = (Button) findViewById(R.id.btn_list_view_demo_activity);
        mSensorsListButton = (Button) findViewById(R.id.btn_sensors_list_activity);

        mListViewDemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListViewApps.this, ListViewDemoActivity.class);
                startActivity(i);
            }
        });

        mSensorsListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListViewApps.this, SensorsListViewActivity.class);
                startActivity(i);
            }
        });
    }
}
