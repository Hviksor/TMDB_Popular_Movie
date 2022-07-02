package com.example.tmdbpopularmovie.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbpopularmovie.REALIZATIONDB
import com.example.tmdbpopularmovie.data.retrofit.RetrofitRepository
import com.example.tmdbpopularmovie.data.room.MoviesRoomDataBase
import com.example.tmdbpopularmovie.data.room.repository.MoviesRepositoryImpl
import com.example.tmdbpopularmovie.models.TMDBInformation
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewMode(application: Application) : AndroidViewModel(application) {
    private val context = application
    private val repo = RetrofitRepository()
    val myMovies: MutableLiveData<Response<TMDBInformation>> = MutableLiveData()

    init {
        getMoviesRetrofit()
        initDataBase()
    }

    private fun getMoviesRetrofit() {
        viewModelScope.launch {
            myMovies.value = repo.getPopularMovie()
        }
    }

    private fun initDataBase() {
        val moviesDao = MoviesRoomDataBase.getInstanceDB(context).getDao()
        REALIZATIONDB = MoviesRepositoryImpl(moviesDao)
    }
}