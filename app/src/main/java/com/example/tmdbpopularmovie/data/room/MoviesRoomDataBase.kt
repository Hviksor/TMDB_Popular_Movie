package com.example.tmdbpopularmovie.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tmdbpopularmovie.data.room.dao.MoviesDao
import com.example.tmdbpopularmovie.models.MovieItem

@Database(entities = [MovieItem::class], version = 2)
abstract class MoviesRoomDataBase : RoomDatabase() {
    abstract fun getDao(): MoviesDao

    companion object {
        private val db: MoviesRoomDataBase? = null

        fun getInstanceDB(context: Context): MoviesRoomDataBase {
            return if (db == null) {
                val db = Room.databaseBuilder(context, RoomDatabase::class.java, "db").build()
                db as MoviesRoomDataBase
            } else {
                db as MoviesRoomDataBase
            }

        }
    }
}