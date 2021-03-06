package com.example.donate4life;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface WebApi {

    @POST("masterLogin")
    @FormUrlEncoded
    Call<LoginResponse> userLogin(@Field("email") String email, @Field("password") String password);

}
