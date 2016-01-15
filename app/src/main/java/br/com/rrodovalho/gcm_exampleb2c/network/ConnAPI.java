package br.com.rrodovalho.gcm_exampleb2c.network;

import br.com.rrodovalho.gcm_exampleb2c.domain.User;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;


/**
 * Created by rrodovalho on 10/01/16.
 */
public interface ConnAPI {

    @POST("/user/register")
    Call<User> registerUser(@Body User user);
}
