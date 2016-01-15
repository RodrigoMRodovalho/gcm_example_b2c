package br.com.rrodovalho.gcm_exampleb2c.network;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by rrodovalho on 10/01/16.
 */
public class ConnManager {

    private static final String API = "http://192.168.25.3:8080";
    private ConnAPI connAPI = null;
    private static ConnManager instance = null;

    private ConnManager(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        connAPI = retrofit.create(ConnAPI.class);
    }

    public static ConnManager getInstance(){
        if(instance==null){
            instance = new ConnManager();
        }
        return instance;
    }

    public ConnAPI getConnAPI(){
        return this.connAPI;
    }


}
