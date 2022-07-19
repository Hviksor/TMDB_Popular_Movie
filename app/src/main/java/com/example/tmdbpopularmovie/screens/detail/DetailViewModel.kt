package com.example.tmdbpopularmovie.screens.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbpopularmovie.data.retrofit.RetroFitRepository
import com.example.tmdbpopularmovie.model.MovieItem
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailViewModel : ViewModel() {
    val repo = RetroFitRepository()

    val singleMovieInfo: MutableLiveData<Response<MovieItem>> = MutableLiveData()

    fun getSingleMovieInfo(movieId: Int) {
        viewModelScope.launch {
            singleMovieInfo.value = repo.getSingleMovieInfo(movieId)
        }
    }

}