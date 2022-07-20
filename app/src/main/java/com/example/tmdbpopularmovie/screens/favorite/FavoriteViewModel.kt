package com.example.tmdbpopularmovie.screens.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tmdbpopularmovie.REALISATION_DB
import com.example.tmdbpopularmovie.model.MovieItem

class FavoriteViewModel : ViewModel() {
    fun getAllFavoritesMovie(): LiveData<List<MovieItem>> {
       return REALISATION_DB.allMovie
    }
}