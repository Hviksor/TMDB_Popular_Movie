package com.example.tmdbpopularmovie.data.room.repository

import androidx.lifecycle.LiveData
import com.example.tmdbpopularmovie.data.room.dao.MoviesDao
import com.example.tmdbpopularmovie.models.MovieItem


class MoviesRepositoryImpl(private val dao: MoviesDao) : MoviesRepository {
    override suspend fun insertMovie(movieItem: MovieItem, onSuccess: () -> Unit) {
        dao.insert(movieItem)
        onSuccess
    }

    override suspend fun deleteMovie(movieItem: MovieItem, onSuccess: () -> Unit) {
        dao.delete(movieItem)
        onSuccess
    }

    override val allMovies: LiveData<List<MovieItem>>
        get() = dao.getAllMovies()

}