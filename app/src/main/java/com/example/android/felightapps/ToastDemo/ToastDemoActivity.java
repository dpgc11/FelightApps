package com.example.android.felightapps.ToastDemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.felightapps.R;

/**
 * Created by Yogesh on 02-02-2017.
 */

public class ToastDemoActivity extends AppCompatActivity{

    Button mTopLeftButton;
    Button mTopRightButton;
    Button mCenterButton;
    Button mBottomLeftButton;
    Button mBottomRightButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_demo);

        mTopLeftButton = (Button) findViewById(R.id.btn_top_left);
        mTopRightButton = (Button) findViewById(R.id.btn_top_right);
        mCenterButton = (Button) findViewById(R.id.btn_center);
        mBottomLeftButton = (Button) findViewById(R.id.btn_bottom_left);
        mBottomRightButton = (Button) findViewById(R.id.btn_bottom_right);

        mTopLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Toast: Top Left", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
                toast.show();
            }
        });

        mTopRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Toast: Top Right", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.RIGHT | Gravity.TOP, 0, 0);
                toast.show();
            }
        });

        mCenterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Toast: Center", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

        mBottomLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Toast: Bottom Left", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
                toast.show();
            }
        });

        mBottomRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Toast: Bottom Right", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
                toast.show();
            }
        });

    }
}
