package com.example.tmdbpopularmovie.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tmdbpopularmovie.data.room.dao.MoviesDao
import com.example.tmdbpopularmovie.models.MovieItem

@Database(entities = [MovieItem::class], version = 4)
abstract class MoviesRoomDataBase : RoomDatabase() {
    abstract fun getDao(): MoviesDao

    companion object {
        private var database: MoviesRoomDataBase? = null

        fun getInstanceDB(context: Context): MoviesRoomDataBase {
            return if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    MoviesRoomDataBase::class.java,
                    "db"
                ).build()
                database as MoviesRoomDataBase
            } else {
                database as MoviesRoomDataBase
            }

        }
    }
}