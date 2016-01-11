package br.com.rrodovalho.gcm_exampleb2c;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import br.com.rrodovalho.gcm_exampleb2c.R;
import br.com.rrodovalho.gcm_exampleb2c.gcm_service.RegistrationIntentService;
import br.com.rrodovalho.gcm_exampleb2c.message.PushMessage;
import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    public final static String SENDER_API_KEY="AIzaSyDszwo1XOan77b6HQ4cHCoPq0l-BEGIeSs";
    public final static String SENDER_ID="296694209649";

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

        if( checkPlayServices() ){
            Intent it = new Intent(this, RegistrationIntentService.class);
            startService(it);
        }
    }


    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i("LOG", "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }

    public void onEvent(PushMessage message){

        String title = message.getTitle();
        String msg = message.getMessage();

        Log.i("PUSH","Title  "+title);
        Log.i("PUSH","Message  "+msg);

    }
}
