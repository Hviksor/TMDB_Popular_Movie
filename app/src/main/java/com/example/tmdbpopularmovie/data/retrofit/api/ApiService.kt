package com.example.tmdbpopularmovie.data.retrofit.api

import com.example.tmdbpopularmovie.model.MovieItem
import com.example.tmdbpopularmovie.model.TMDBInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("3/movie/popular?")
    suspend fun getTMDBInformation(
        @Query(QUERY_API_KEY) apiKey: String = API_KEY,
        @Query(QUERY_LANGUAGE) language: String = LANGUAGE,
        @Query(QUERY_PAGE) page: String = PAGE
    ): Response<TMDBInfo>

    @GET("3/movie/{movieId}?")
    suspend fun getSingleMovieInfo(
        @Path("movieId") movieId: Int,
        @Query(QUERY_API_KEY) apiKey: String = API_KEY,
        @Query(QUERY_LANGUAGE) language: String = LANGUAGE
    ): Response<MovieItem>

    companion object {
        const val QUERY_API_KEY = "api_key"
        const val QUERY_LANGUAGE = "language"
        const val QUERY_PAGE = "page"

        const val API_KEY = "cafa669d828b93b4e5f024b227e17c34"
        const val LANGUAGE = "en-US"
        const val PAGE = "1"
    }

}
