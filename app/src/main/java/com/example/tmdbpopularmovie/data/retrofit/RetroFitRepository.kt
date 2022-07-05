package com.example.tmdbpopularmovie.data.retrofit

import com.example.tmdbpopularmovie.data.retrofit.api.ApiService
import com.example.tmdbpopularmovie.data.retrofit.api.RetroFitInstance
import com.example.tmdbpopularmovie.model.TMDBInfo
import retrofit2.Response
import retrofit2.http.Query

class RetroFitRepository {
    suspend fun getTMDBInformation(): Response<TMDBInfo> {
        return RetroFitInstance.api.getTMDBInformation()
    }
}