package com.example.android.felightapps.BraodcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AirplaneAndBootReceiver extends BroadcastReceiver {

    private static final String TAG = AirplaneAndBootReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive() Called");

    }
}
