package com.example.android.felightapps.NotificationsDemo;

import android.app.NotificationManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import com.example.android.felightapps.R;

public class NotificationDemoActivity extends AppCompatActivity {

    private Button mGenerateNotificationButton;
    private Button mPlaySoundButton;
    private Button mVibrateButton;
    private Button mDoEverythingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_demo);

        mGenerateNotificationButton = (Button) findViewById(R.id.btn_generate_notification);
        mPlaySoundButton = (Button) findViewById(R.id.btn_play_sound);
        mVibrateButton = (Button) findViewById(R.id.btn_vibrate);
        mDoEverythingButton = (Button) findViewById(R.id.btn_do_all_of_the_above);

        mGenerateNotificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateNotification();
            }
        });

        mPlaySoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound();
            }
        });

        mVibrateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrateDevice();
            }
        });

        mDoEverythingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateNotification();
                playSound();
                vibrateDevice();
            }
        });
    }

    private void generateNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.ic_adb_black_24dp)
                        .setContentTitle("BREAKING NEWS!!!")
                        .setContentText("News");

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }

    private void playSound() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.namaste);
        mp.start();
    }

    private void vibrateDevice() {
        Vibrator v = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(500);
    }
}
