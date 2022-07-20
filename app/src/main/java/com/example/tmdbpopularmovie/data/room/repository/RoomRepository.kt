package com.example.tmdbpopularmovie.data.room.repository

import androidx.lifecycle.LiveData
import com.example.tmdbpopularmovie.model.MovieItem

interface RoomRepository {
    suspend fun deleteMovieFromFavorite(movieItem: MovieItem, onSuccess: () -> Unit)
    suspend fun insertMovieFromFavorite(movieItem: MovieItem, onSuccess: () -> Unit)
    val allMovie: LiveData<List<MovieItem>>
    suspend fun getSingleMovieInfo(movieId: Int): LiveData<MovieItem>
}