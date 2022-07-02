package com.example.tmdbpopularmovie.screens.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tmdbpopularmovie.REALIZATIONDB
import com.example.tmdbpopularmovie.data.room.repository.MoviesRepositoryImpl
import com.example.tmdbpopularmovie.models.MovieItem

class FavoriteFragmentViewModel : ViewModel() {
    fun getAllMovies(): LiveData<List<MovieItem>> {
        return REALIZATIONDB.allMovies
    }


}