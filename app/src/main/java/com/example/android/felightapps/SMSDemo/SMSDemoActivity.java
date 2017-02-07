package com.example.android.felightapps.SMSDemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.felightapps.R;

public class SMSDemoActivity extends AppCompatActivity {

    private static final int REQUEST_SEND_SMS = 1;
    private EditText mMobileNumberEditText;
    private EditText mSMSTextEditText;
    private Button mSendSMSButton;
    private String mPhoneNumber;
    private String mTextContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsdemo);

        mMobileNumberEditText = (EditText) findViewById(R.id.et_mobile_number);
        mSMSTextEditText = (EditText) findViewById(R.id.et_sms_text);
        mSendSMSButton = (Button) findViewById(R.id.btn_send_sms);



        mSendSMSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPhoneNumber = "+91" + mMobileNumberEditText.getText().toString();
                mTextContent = mSMSTextEditText.getText().toString();
                SendSms(mPhoneNumber, mTextContent);
            }
        });

    }

    private void SendSms(String phoneNumber, String message) {
        int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.SEND_SMS);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Toast.makeText(this, "Sms Sent", Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.SEND_SMS}, REQUEST_SEND_SMS);
        }

    }
}
