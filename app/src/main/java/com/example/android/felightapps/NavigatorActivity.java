package com.example.android.felightapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.example.android.felightapps.AlgorithmBenchmarking.BenchmarkingActivity;
import com.example.android.felightapps.AnimationsDemo.AnimationsDemoActivity;
import com.example.android.felightapps.Calculator.CalculatorActivity;
import com.example.android.felightapps.Flashlight.FlashlightActivity;
import com.example.android.felightapps.InstagramClone.InstagramCloneActivity;
import com.example.android.felightapps.Maps.MapsActivity;
import com.example.android.felightapps.NotificationsDemo.NotificationDemoActivity;
import com.example.android.felightapps.ToastDemo.ToastDemoActivity;
import com.example.android.felightapps.WebViewDemo.WebViewDemoActivity;

public class NavigatorActivity extends AppCompatActivity {

    private Button mBenchmarkingButton;
    private Button mFlashlightButton;
    private Button mInstagramCloneButton;
    private Button mCalculatorButton;
    private Button mToastDemoButton;
    private Button mNotificationDemoButton;
    private Button mAnimationDemoButton;
    private Button mWebViewDemoButton;
    private Button mMapsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator);

        mBenchmarkingButton = (Button) findViewById(R.id.btn_benchmarking);
        mFlashlightButton = (Button) findViewById(R.id.btn_flashlight);
        mInstagramCloneButton = (Button) findViewById(R.id.btn_instagram_clone);
        mCalculatorButton = (Button) findViewById(R.id.btn_calculator);
        mToastDemoButton = (Button) findViewById(R.id.btn_toast_demo);
        mNotificationDemoButton = (Button) findViewById(R.id.btn_notification_demo);
        mAnimationDemoButton = (Button) findViewById(R.id.btn_animation_demo);
        mWebViewDemoButton = (Button) findViewById(R.id.btn_webview_demo);
        mMapsButton = (Button) findViewById(R.id.btn_maps);

        mBenchmarkingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NavigatorActivity.this, BenchmarkingActivity.class);
                startActivity(i);
            }
        });

        mFlashlightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NavigatorActivity.this, FlashlightActivity.class);
                startActivity(i);
            }
        });

        mInstagramCloneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NavigatorActivity.this, InstagramCloneActivity.class);
                startActivity(i);
            }
        });

        mCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NavigatorActivity.this, CalculatorActivity.class);
                startActivity(i);
            }
        });


        mToastDemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NavigatorActivity.this, ToastDemoActivity.class);
                startActivity(i);
            }
        });

        mNotificationDemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NavigatorActivity.this, NotificationDemoActivity.class);
                startActivity(i);
            }
        });

        mAnimationDemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NavigatorActivity.this, AnimationsDemoActivity.class);
                startActivity(i);
            }
        });

        mWebViewDemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NavigatorActivity.this, WebViewDemoActivity.class);
                startActivity(i);
            }
        });

        mMapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NavigatorActivity.this, MapsActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(getApplicationContext());
        inflater.inflate(R.menu.felight_apps_menu, menu);
        return true;
    }
}
