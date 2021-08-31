package com.benny.retrofitkotlinmysql

data class CrudResponse(
    val value: Boolean,
    val message: String,
    val `data`: ModelMahasiswa,
)