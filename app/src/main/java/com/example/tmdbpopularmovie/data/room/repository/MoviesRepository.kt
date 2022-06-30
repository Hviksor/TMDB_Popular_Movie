package com.example.tmdbpopularmovie.data.room.repository

import androidx.lifecycle.LiveData
import com.example.tmdbpopularmovie.models.MovieItem

interface MoviesRepository {

    suspend fun insertMovie(movieItem: MovieItem, onSuccess: () -> Unit)
    suspend fun deleteMovie(movieItem: MovieItem, onSuccess: () -> Unit)

    val allMovies: LiveData<List<MovieItem>>
}