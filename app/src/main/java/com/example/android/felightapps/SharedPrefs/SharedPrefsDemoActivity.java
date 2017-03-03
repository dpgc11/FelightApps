package com.example.android.felightapps.SharedPrefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.felightapps.R;

public class SharedPrefsDemoActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    Button b1;

    private static final String MY_PREFERENCES = "MyPreferences";
    private static final String NAME = "nameKey";
    private static final String PHONE = "phoneKey";
    private static final String EMAIL = "emailKey";

    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefs_demo);

        ed1=(EditText)findViewById(R.id.et_nameEditText_sharedPrefs);
        ed2=(EditText)findViewById(R.id.et_password_sharedPrefs);
        ed3=(EditText)findViewById(R.id.et_email_sharedPrefs);

        b1=(Button)findViewById(R.id.btn_save_sharedPrefs);
        mSharedPreferences = getApplicationContext().getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n  = ed1.getText().toString();
                String ph  = ed2.getText().toString();
                String e  = ed3.getText().toString();

                SharedPreferences.Editor editor = mSharedPreferences.edit();

                editor.putString(NAME, n);
                editor.putString(PHONE, ph);
                editor.putString(EMAIL, e);
                editor.commit();
                Toast.makeText(getApplicationContext() ,"Saved", Toast.LENGTH_LONG).show();
            }
        });

        if (mSharedPreferences.contains(NAME)) {
            ed1.setText(mSharedPreferences.getString(NAME, ""));
        }

        if (mSharedPreferences.contains(PHONE)) {
            ed2.setText(mSharedPreferences.getString(PHONE, ""));
        }

        if (mSharedPreferences.contains(EMAIL)) {
            ed3.setText(mSharedPreferences.getString(EMAIL, ""));
        }
    }
}
