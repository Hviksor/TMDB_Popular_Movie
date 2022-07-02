package com.example.tmdbpopularmovie.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tmdbpopularmovie.models.MovieItem

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(movieItem: MovieItem)

    @Delete
    fun delete(movieItem: MovieItem)

    @Query("SELECT * from movie_table")
    fun getAllMovies(): LiveData<List<MovieItem>>
}