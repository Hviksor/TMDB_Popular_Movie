package com.example.tmdbpopularmovie.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbpopularmovie.data.retrofit.RetrofitRepository
import com.example.tmdbpopularmovie.models.TMDBInformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewMode : ViewModel() {
    private val repo = RetrofitRepository()
    val myMovies: MutableLiveData<Response<TMDBInformation>> = MutableLiveData()


    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            myMovies.value = repo.getPopularMovie()
        }
    }
}