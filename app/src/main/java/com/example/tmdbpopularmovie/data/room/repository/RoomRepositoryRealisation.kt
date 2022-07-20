package com.example.tmdbpopularmovie.data.room.repository

import androidx.lifecycle.LiveData
import com.example.tmdbpopularmovie.data.room.dao.MovieDao
import com.example.tmdbpopularmovie.model.MovieItem

class RoomRepositoryRealisation(private val dao: MovieDao) : RoomRepository {
    override suspend fun deleteMovieFromFavorite(movieItem: MovieItem, onSuccess: () -> Unit) {
        dao.deleteMovieFromFavorite(movieItem)
        onSuccess
    }

    override suspend fun insertMovieFromFavorite(movieItem: MovieItem, onSuccess: () -> Unit) {
        dao.insertMovieFromFavorite(movieItem)
        onSuccess
    }

    override val allMovie: LiveData<List<MovieItem>>
        get() = dao.getMovieInfo()

    override suspend fun getSingleMovieInfo(movieId: Int): LiveData<MovieItem> {
        return dao.getSingleMovieInfoDB(movieId)
    }
}