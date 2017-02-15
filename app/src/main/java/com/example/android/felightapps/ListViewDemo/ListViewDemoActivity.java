package com.example.android.felightapps.ListViewDemo;

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

public class ListViewDemoActivity extends AppCompatActivity {

    private ListView mColorsListView;
    private List<String> mColorsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);

        mColorsListView = (ListView) findViewById(R.id.lv_color_list);
        initColors();
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, mColorsList);
        mColorsListView.setAdapter(colorAdapter);
        mColorsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String currentColor = mColorsList.get(i);
                Toast.makeText(getApplicationContext(), currentColor.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initColors() {
        mColorsList = new ArrayList<>();
        mColorsList.add("Red");
        mColorsList.add("Blue");
        mColorsList.add("Black");
        mColorsList.add("White");
        mColorsList.add("Violet");
        mColorsList.add("Indigo");
        mColorsList.add("Green");
        mColorsList.add("Yellow");
        mColorsList.add("Orange");
    }
}
