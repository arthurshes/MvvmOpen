package com.example.dagger222.Api

import com.example.dagger222.DB.DbModel
import retrofit2.Call
import retrofit2.http.GET

interface RestApi {
    @GET("all")
    fun getAllCountres(): Call<List<DbModel>>
}