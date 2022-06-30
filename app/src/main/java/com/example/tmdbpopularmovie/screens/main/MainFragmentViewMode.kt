package com.example.tmdbpopularmovie.screens.main

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbpopularmovie.APP
import com.example.tmdbpopularmovie.data.retrofit.RetrofitRepository
import com.example.tmdbpopularmovie.models.TMDBInformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewMode : ViewModel() {
    private val repo = RetrofitRepository()
    val myMovies: MutableLiveData<Response<TMDBInformation>> = MutableLiveData()

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
                myMovies.value = repo.getPopularMovie()
        }
    }
}