package br.com.rrodovalho.gcm_exampleb2c.gcm_service;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by rrodovalho on 10/01/16.
 */
public class CustomInstanceIDListenerService extends InstanceIDListenerService {

    private static final String TAG = "LOG";


    @Override
    public void onTokenRefresh() {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.edit().putBoolean("status", false ).apply();


        Intent it = new Intent(this, RegistrationIntentService.class);
        startService(it);
    }
}

