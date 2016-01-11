package br.com.rrodovalho.gcm_exampleb2c.gcm_service;

import android.os.Bundle;
import com.google.android.gms.gcm.GcmListenerService;

import br.com.rrodovalho.gcm_exampleb2c.message.PushMessage;
import de.greenrobot.event.EventBus;

/**
 * Created by rrodovalho on 10/01/16.
 */
public class CustomGcmListenerService extends GcmListenerService {

    public static final String LOG = "LOG";

    @Override
    public void onMessageReceived(String from, Bundle data) {

        String title = data.getString("title");
        String message = data.getString("message");

        EventBus.getDefault().post(new PushMessage(title, message));
    }
}
