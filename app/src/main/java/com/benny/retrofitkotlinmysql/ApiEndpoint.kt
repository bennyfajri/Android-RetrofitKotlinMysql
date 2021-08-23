package com.benny.retrofitkotlinmysql

import android.renderscript.Sampler
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiEndpoint {

    @POST("insert.php")
    fun insert(
        @Body mahasiswa: ModelMahasiswa
    ): Call<ModelMahasiswa>
}