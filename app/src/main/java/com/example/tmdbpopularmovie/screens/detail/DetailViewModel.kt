package com.example.tmdbpopularmovie.screens.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbpopularmovie.REALISATION_DB
import com.example.tmdbpopularmovie.data.retrofit.RetroFitRepository
import com.example.tmdbpopularmovie.model.MovieItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailViewModel : ViewModel() {
    val repo = RetroFitRepository()
    val singleMovieInfo: MutableLiveData<Response<MovieItem>> = MutableLiveData()
    val isFavorite: MutableLiveData<Boolean> = MutableLiveData()

    fun getSingleMovieInfoTMDB(movieId: Int) {
        viewModelScope.launch {
            singleMovieInfo.value = repo.getSingleMovieInfo(movieId)
        }
    }

    fun chekFavorite(movieId: Int) {
        viewModelScope.launch(Dispatchers.Default) {
            val result = REALISATION_DB.chekFavorite(movieId)
            isFavorite.postValue(result)
        }
    }

    fun addToFavorite(movieItem: MovieItem, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REALISATION_DB.insertMovieFromFavorite(movieItem, onSuccess)
        }

    }

    fun deleteToFavorite(movieItem: MovieItem, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REALISATION_DB.deleteMovieFromFavorite(movieItem, onSuccess)
        }
    }


}