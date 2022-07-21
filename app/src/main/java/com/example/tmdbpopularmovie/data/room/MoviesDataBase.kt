package com.example.tmdbpopularmovie.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tmdbpopularmovie.data.room.dao.MovieDao
import com.example.tmdbpopularmovie.model.MovieItem

@Database(entities = [MovieItem::class], version = 4)
abstract class MoviesDataBase : RoomDatabase() {
    abstract fun getDao(): MovieDao


    companion object {
        private var instance: MoviesDataBase? = null

        @Synchronized
        fun getInstanceDDB(context: Context): MoviesDataBase {
            return if (instance == null) {
                instance = Room.databaseBuilder(context, MoviesDataBase::class.java, "db").build()
                instance as MoviesDataBase
            } else {
                instance as MoviesDataBase
            }

        }
    }

}