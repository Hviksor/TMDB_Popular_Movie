package com.example.tmdbpopularmovie.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tmdbpopularmovie.model.MovieItem

@Dao
interface MovieDao {
    @Delete
    fun deleteMovieFromFavorite(movieItem: MovieItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieFromFavorite(movieItem: MovieItem)

    @Query("SELECT * from movie_table")
    fun getMovieInfo(): LiveData<List<MovieItem>>

    @Query("SELECT * from movie_table WHERE id==:movieId LIMIT 1")
    fun getSingleMovieInfoDB(movieId: Int): LiveData<MovieItem>


}