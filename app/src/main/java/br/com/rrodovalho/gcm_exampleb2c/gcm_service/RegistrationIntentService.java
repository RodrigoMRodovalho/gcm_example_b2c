package br.com.rrodovalho.gcm_exampleb2c.gcm_service;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

import br.com.rrodovalho.gcm_exampleb2c.MainActivity;
import br.com.rrodovalho.gcm_exampleb2c.domain.User;

/**
 * Created by rrodovalho on 10/01/16.
 */
public class RegistrationIntentService extends IntentService {

    public static final String LOG = "LOG";

    public RegistrationIntentService() {
        super(LOG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean status = preferences.getBoolean("status", false);


        synchronized (LOG) {
            InstanceID instanceID = InstanceID.getInstance(this);
            try {


                if (!status) {
                    String token = instanceID.getToken(MainActivity.SENDER_ID,
                            GoogleCloudMessaging.INSTANCE_ID_SCOPE,
                            null);


                    Log.i(LOG, "TOKEN: " + token);


                    //preferences.edit().putBoolean("status", token != null && token.trim().length() > 0).apply();


//                    sendRegistrationId(token);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void sendRegistrationId( String token ){
        User user = new User();
        user.setRegistrationId( token );

        //TODO - make a retrofit call
        /*NetworkConnection
                .getInstance(this)
                .execute(new WrapObjToNetwork(user, "save-user"), RegistrationIntentService.class.getName());*/
    }
}

