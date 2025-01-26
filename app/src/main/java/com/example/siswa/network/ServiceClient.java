package com.example.siswa.network;

import com.example.siswa.model.LoginResponse;
import com.example.siswa.model.SppResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ServiceClient {
    @POST("exec")
    @FormUrlEncoded
    Call<LoginResponse> loginSiswa(@Field(value = "sheetName", encoded = true)String sheetName,
                                                          @Field(value = "action", encoded = true)String action,
                                                          @Field(value = "tingkatan", encoded = true)String tingkatan,
                                                          @Field(value = "tahunAjaran", encoded = true)String tahunAjaran,
                                                          @Field(value = "nis", encoded = true)String nis,
                                                          @Field(value = "pass", encoded = true)String pass);


    @GET("exec")
    Call<SppResponse> readSpp(@Query("sheetName")String sheetName,
                              @Query("action")String action,
                              @Query("tingkatan")String tingkatan,
                              @Query("tahunAjaran")String tahunAjaran,
                              @Query("kelas")String kelas,
                              @Query("nis")String nis);
}
