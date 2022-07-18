package com.example.tmdbpopularmovie.data.retrofit.api

import com.example.tmdbpopularmovie.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetroFitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api = retrofit.create(ApiService::class.java)

}