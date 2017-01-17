package com.example.android.felightapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.felightapps.AlgorithmBenchmarking.BenchmarkingActivity;
import com.example.android.felightapps.Calculator.CalculatorActivity;
import com.example.android.felightapps.Flashlight.FlashlightActivity;
import com.example.android.felightapps.InstagramClone.InstagramCloneActivity;

public class NavigatorActivity extends AppCompatActivity {

    private Button mBenchmarkingButton;
    private Button mFlashlightButton;
    private Button mInstagramCloneButton;
    private Button mCalculatorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator);

        mBenchmarkingButton = (Button) findViewById(R.id.btn_benchmarking);
        mFlashlightButton = (Button) findViewById(R.id.btn_flashlight);
        mInstagramCloneButton = (Button) findViewById(R.id.btn_instagram_clone);
        mCalculatorButton = (Button) findViewById(R.id.btn_calculator);

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
    }
}
