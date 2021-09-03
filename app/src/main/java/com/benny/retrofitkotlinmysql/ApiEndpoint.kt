package com.benny.retrofitkotlinmysql

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndpoint {

    @POST("insert.php")
    fun insert(
        @Body mahasiswa: ModelMahasiswa
    ): Call<CrudResponse>

    @GET("read.php")
    fun read(): Call<ModelMahasiswa>

    @POST("update.php")
    fun update(
        @Body mahasiswa: ModelMahasiswa
    ): Call<CrudResponse>

}