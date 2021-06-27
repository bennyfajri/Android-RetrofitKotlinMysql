package com.benny.retrofitkotlinmysql

import android.renderscript.Sampler
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface InsertAPI {
    @FormUrlEncoded
    @POST("insert.php")
    fun insert(
        @Field("nama") nama: String?,
        @Field("email") email: String?,
        @Field("nohp") nomor: String?,
        @Field("ukt") ukt: String?,
    ): Call<Sampler.Value?>?
}