package com.example.tmdbpopularmovie.screens.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbpopularmovie.REALISATION_DB
import com.example.tmdbpopularmovie.data.retrofit.RetroFitRepository
import com.example.tmdbpopularmovie.data.room.MoviesDataBase
import com.example.tmdbpopularmovie.data.room.repository.RoomRepositoryRealisation
import com.example.tmdbpopularmovie.model.TMDBInfo
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val context = application
    private val repoRetrofit = RetroFitRepository()
    val tmdbInfo: MutableLiveData<Response<TMDBInfo>> = MutableLiveData()

    init {
        getTMDBInfo()
        initDB()
    }

    private fun initDB() {
        val moviesDBDao = MoviesDataBase.getInstanceDDB(context).getDao()
        REALISATION_DB = RoomRepositoryRealisation(moviesDBDao)
    }

    private fun getTMDBInfo() {
        viewModelScope.launch {
            tmdbInfo.value = repoRetrofit.getTMDBInformation()
        }
    }
}