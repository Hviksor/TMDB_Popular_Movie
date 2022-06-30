package com.example.tmdbpopularmovie.data.retrofit

import com.example.tmdbpopularmovie.data.retrofit.api.ApiService
import com.example.tmdbpopularmovie.data.retrofit.api.RetroFitInstance
import com.example.tmdbpopularmovie.models.TMDBInformation
import retrofit2.Response

class RetrofitRepository {
    suspend fun getPopularMovie(): Response<TMDBInformation> {
        return RetroFitInstance.api.getPopularMovie()
    }
}