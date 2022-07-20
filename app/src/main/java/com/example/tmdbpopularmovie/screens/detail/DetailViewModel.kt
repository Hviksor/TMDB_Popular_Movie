package com.example.tmdbpopularmovie.screens.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbpopularmovie.REALISATION_DB
import com.example.tmdbpopularmovie.data.retrofit.RetroFitRepository
import com.example.tmdbpopularmovie.model.MovieItem
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailViewModel : ViewModel() {
    val repo = RetroFitRepository()

    val singleMovieInfo: MutableLiveData<Response<MovieItem>> = MutableLiveData()
    val singleMovieInfoMyDb: MutableLiveData<MovieItem> = MutableLiveData()

    fun getSingleMovieInfoTMDB(movieId: Int) {
        viewModelScope.launch {
            singleMovieInfo.value = repo.getSingleMovieInfo(movieId)
        }
    }

    fun getSingleMovieInfoFromMyDB(movieId: Int) {
        viewModelScope.launch {
            singleMovieInfoMyDb.value = REALISATION_DB.getSingleMovieInfo(movieId).value
        }
    }

    fun addToFavorite(movieItem: MovieItem, onSuccess: () -> Unit) {
        viewModelScope.launch {
            REALISATION_DB.insertMovieFromFavorite(movieItem, onSuccess)
        }

    }

    fun deleteToFavorite(movieItem: MovieItem, onSuccess: () -> Unit) {
        viewModelScope.launch {
            REALISATION_DB.deleteMovieFromFavorite(movieItem, onSuccess)
        }
    }

}