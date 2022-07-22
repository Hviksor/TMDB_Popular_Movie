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

//    @Query("SELECT * from movie_table WHERE id==:movieId LIMIT 1")
//    fun getSingleMovieInfoDB(movieId: Int): LiveData<MovieItem>
//
//    @Query("SELECT EXISTS (SELECT 1 FROM movie_table WHERE id == :movieId)")
//    fun chekFavorite(movieId: Int): LiveData<Boolean>
//
//    @Query("SELECT  EXISTS(SELECT id FROM table WHERE id = 1)")
//    fun chekFavorite(movieId: Int): LiveData<Boolean>

//    @Query("SELECT * FROM movie_table WHERE id = :movieId LIMIT 1")
//    fun chekFavorite(movieId: Int): LiveData<MovieItem>

    @Query("SELECT EXISTS (SELECT 1 FROM movie_table WHERE id = :movieId)")
    fun chekFavorite(movieId: Int): Boolean


}