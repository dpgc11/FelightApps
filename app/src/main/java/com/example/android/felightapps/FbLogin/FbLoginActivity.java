package com.example.android.felightapps.FbLogin;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.felightapps.R;

import java.util.Calendar;

public class FbLoginActivity extends AppCompatActivity {

    private static final int DATE_DIALOG_ID = 999;
    private TextView mDOBTextView;
    private DatePicker mDOBDatePicker;
    private EditText mNameEditText;
    private EditText mPhoneEditText;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private EditText mReEnterPasswordEditText;
    private Button mRegisterButton;
    private RadioGroup mGenderRadioGroup;
    private RadioButton mMaleRadioButton;
    private RadioButton mFemaleRadioButton;
    private RadioButton mOtherRadioButton;
    private SharedPreferences mSharedPreferences;
    private static final String MY_PREFS = "MyPrefs";
    private static final String NAME = "nameKey";
    private static final String PHONE = "phoneKey";
    private static final String EMAIL = "emailKey";
    private static final String PASSWORD = "passwordKey";


    private int year;
    private int month;
    private int day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb_login);

        mNameEditText = (EditText) findViewById(R.id.et_full_name);
        mPhoneEditText = (EditText) findViewById(R.id.et_mobile);
        mEmailEditText = (EditText) findViewById(R.id.et_email);
        mPasswordEditText = (EditText) findViewById(R.id.et_password);
        mReEnterPasswordEditText = (EditText) findViewById(R.id.et_password_again);
        mRegisterButton = (Button) findViewById(R.id.btn_register);
        mGenderRadioGroup = (RadioGroup) findViewById(R.id.rg_gender);
        mMaleRadioButton = (RadioButton) findViewById(R.id.rb_male);
        mFemaleRadioButton = (RadioButton) findViewById(R.id.rb_other);
        mOtherRadioButton = (RadioButton) findViewById(R.id.rb_female);
        mSharedPreferences = getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);

        setCurrentDateOnView();
        addListenerOnTextView();

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (performDataValidation()) {
                    registrationDone();
                }

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        String n  = mNameEditText.getText().toString();
        String ph  = mPhoneEditText.getText().toString();
        String e  = mEmailEditText.getText().toString();
        String pass = mPasswordEditText.getText().toString();

        SharedPreferences.Editor editor = mSharedPreferences.edit();

        editor.putString(NAME, n);
        editor.putString(PHONE, ph);
        editor.putString(EMAIL, e);
        editor.putString(PASSWORD, pass);
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mSharedPreferences.contains(NAME))
            mNameEditText.setText(mSharedPreferences.getString(NAME, ""));
        if (mSharedPreferences.contains(PHONE))
            mPhoneEditText.setText(mSharedPreferences.getString(PHONE, ""));
        if (mSharedPreferences.contains(EMAIL))
            mEmailEditText.setText(mSharedPreferences.getString(EMAIL, ""));
        if (mSharedPreferences.contains(PASSWORD))
            mPasswordEditText.setText(mSharedPreferences.getString(PASSWORD, ""));

    }

    public void setCurrentDateOnView() {

        mDOBTextView = (TextView) findViewById(R.id.tv_dob);
        mDOBDatePicker = (DatePicker) findViewById(R.id.dp_dob);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        mDOBTextView.setText(new StringBuilder().append(day).append("/").append(month + 1)
                .append("/").append(year).append(" "));

        mDOBDatePicker.init(year, month, day, null);

    }

    public void addListenerOnTextView() {
        mDOBTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOG_ID);
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:

                return new DatePickerDialog(this, datePickerListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener =
            new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                    year = selectedYear;
                    month = selectedMonth;
                    day = selectedDay;

                    mDOBTextView.setText(new StringBuilder().append(day).append("/")
                            .append(month + 1).append("/")
                            .append(year).append(" "));

                    mDOBDatePicker.init(year, month, day, null);
                }
            };

    private boolean performDataValidation() {

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.error);

        boolean allFieldsFilled = true;
        String name = mNameEditText.getText().toString();
        String phone = mPhoneEditText.getText().toString();
        String email = mEmailEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();
        String rePassword = mReEnterPasswordEditText.getText().toString();
        int genderId = mGenderRadioGroup.getCheckedRadioButtonId();

        if (name.length() == 0) {
            mNameEditText.setError("Name field must not be empty!");
            mNameEditText.startAnimation(animation);
            mp.start();
            allFieldsFilled = false;
        }

        if (phone.length() == 0) {
            mPhoneEditText.setError("Mobile field must not be empty!");
            mPhoneEditText.startAnimation(animation);
            mp.start();
            allFieldsFilled = false;
        }

        if (phone.length() < 10 || phone.length() > 10) {
            mPhoneEditText.setError("Mobile number should contain 10 digits!");
            mPhoneEditText.startAnimation(animation);
            mp.start();
            allFieldsFilled = false;
        }

        if (email.length() == 0) {
            mEmailEditText.setError("Email field must not be empty!");
            mEmailEditText.startAnimation(animation);
            mp.start();
            allFieldsFilled = false;
        }

        if (password.length() < 6) {
            mPasswordEditText.setError("Password must contain at least 6 digits");
            mPasswordEditText.startAnimation(animation);
            mp.start();
            allFieldsFilled = false;
        }

        if (password.length() == 0) {
            mPasswordEditText.setError("Password field must not be empty!");
            mPasswordEditText.startAnimation(animation);
            mp.start();
            allFieldsFilled = false;
        }

        if (rePassword.length() == 0) {
            mReEnterPasswordEditText.setError("Password field must not be empty!");
            mReEnterPasswordEditText.startAnimation(animation);
            mp.start();
            allFieldsFilled = false;
        }

        if (!password.equals(rePassword)) {
            mReEnterPasswordEditText.setError("Passwords do not match");
            mReEnterPasswordEditText.startAnimation(animation);
            mp.start();
            allFieldsFilled = false;
        }

        if (genderId == -1) {
            mOtherRadioButton.setError("Select a gender");
            allFieldsFilled = false;
        }

        return allFieldsFilled;
    }

    private void registrationDone() {
        mNameEditText.setText("");
        mPhoneEditText.setText("");
        mEmailEditText.setText("");
        mPasswordEditText.setText("");
        mReEnterPasswordEditText.setText("");
        Toast.makeText(this, "Registration done!", Toast.LENGTH_LONG).show();
    }


}
