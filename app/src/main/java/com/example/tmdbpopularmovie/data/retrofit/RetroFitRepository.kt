package com.example.tmdbpopularmovie.data.retrofit

import com.example.tmdbpopularmovie.data.retrofit.api.ApiService
import com.example.tmdbpopularmovie.data.retrofit.api.RetroFitInstance
import com.example.tmdbpopularmovie.model.MovieItem
import com.example.tmdbpopularmovie.model.TMDBInfo
import retrofit2.Response
import retrofit2.http.Path
import retrofit2.http.Query
import java.sql.RowId

class RetroFitRepository {
    suspend fun getTMDBInformation(): Response<TMDBInfo> {
        return RetroFitInstance.api.getTMDBInformation()
    }

    suspend fun getSingleMovieInfo(movieId: Int): Response<MovieItem> {
        return RetroFitInstance.api.getSingleMovieInfo(movieId)
    }
}