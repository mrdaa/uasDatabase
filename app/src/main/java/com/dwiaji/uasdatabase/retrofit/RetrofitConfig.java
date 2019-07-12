package com.dwiaji.uasdatabase.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    public static  ApiService getApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/uas_api/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);
        return service;
    }
}
