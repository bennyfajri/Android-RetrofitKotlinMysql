package com.benny.retrofitkotlinmysql

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiEndpoint {

    @POST("insert.php")
    fun insert(
        @Body mahasiswa: ModelMahasiswa
    ): Call<CrudResponse>
}