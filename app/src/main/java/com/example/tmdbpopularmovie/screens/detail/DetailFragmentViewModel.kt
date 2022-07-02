package com.example.tmdbpopularmovie.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbpopularmovie.REALIZATIONDB
import com.example.tmdbpopularmovie.data.room.repository.MoviesRepositoryImpl
import com.example.tmdbpopularmovie.models.MovieItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailFragmentViewModel : ViewModel() {

    fun insert(movieItem: MovieItem, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REALIZATIONDB.insertMovie(movieItem) {
                onSuccess
            }

        }

    fun delete(movieItem: MovieItem, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REALIZATIONDB.deleteMovie(movieItem) {
                onSuccess
            }

        }
    }
}