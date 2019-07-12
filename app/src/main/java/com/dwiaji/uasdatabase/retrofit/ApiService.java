package com.dwiaji.uasdatabase.retrofit;

import com.dwiaji.uasdatabase.model.DataItem;
import com.dwiaji.uasdatabase.model.ResponseBio;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("biodata")
    Call<ResponseBio> ambildata();

    @FormUrlEncoded
    @POST("biodata")
    Call<DataItem> tambahData(
            @Field("nik") String nik,  @Field("nama") String nama,
            @Field("jenis_kelamin") String jenis_kelamin, @Field("alamat") String alamat
    );
}
