package com.example.android.felightapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.android.felightapps.AlgorithmBenchmarking.BenchmarkingActivity;
import com.example.android.felightapps.AnimationsDemo.AnimationsDemoActivity;
import com.example.android.felightapps.Calculator.CalculatorActivity;
import com.example.android.felightapps.FbLogin.FbLoginActivity;
import com.example.android.felightapps.Flashlight.FlashlightActivity;
import com.example.android.felightapps.InstagramClone.InstagramCloneActivity;
import com.example.android.felightapps.ListViewDemo.ListViewApps;
import com.example.android.felightapps.Maps.MapsAppsActivity;
import com.example.android.felightapps.NotificationsDemo.NotificationDemoActivity;
import com.example.android.felightapps.SMSDemo.SMSDemoActivity;
import com.example.android.felightapps.Sensors.SensorListActivity;
import com.example.android.felightapps.Sensors.SensorValuesActivity;
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
    private Button mSendSMSButton;
    private Button mFbLoginButton;
    private Button mSensorsListButton;
    private Button mSensorValuesButton;
    private Button mListViewAppsButton;

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
        mSendSMSButton = (Button) findViewById(R.id.btn_send_sms_activity);
        mFbLoginButton = (Button) findViewById(R.id.btn_fb_login_activity);
        mSensorsListButton = (Button) findViewById(R.id.btn_sensors_list_activity);
        mSensorValuesButton = (Button) findViewById(R.id.btn_sensors_values_activity);
        mListViewAppsButton = (Button) findViewById(R.id.btn_listView_apps_activity);

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
                Intent i = new Intent(NavigatorActivity.this, MapsAppsActivity.class);
                startActivity(i);
            }
        });

        mSendSMSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NavigatorActivity.this, SMSDemoActivity.class);
                startActivity(i);
            }
        });

        mFbLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NavigatorActivity.this, FbLoginActivity.class);
                startActivity(i);
            }
        });

        mSensorsListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NavigatorActivity.this, SensorListActivity.class);
                startActivity(i);
            }
        });

        mSensorValuesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NavigatorActivity.this, SensorValuesActivity.class);
                startActivity(i);
            }
        });

        mListViewAppsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NavigatorActivity.this, ListViewApps.class);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuItem_felight_apps_settings:
                startActivity(new Intent(NavigatorActivity.this, AccountSettingsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
