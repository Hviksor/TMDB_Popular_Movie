package com.example.tmdbpopularmovie.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbpopularmovie.data.retrofit.RetroFitRepository
import com.example.tmdbpopularmovie.model.TMDBInfo
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val repoRetrofit = RetroFitRepository()
    val tmdbInfo: MutableLiveData<Response<TMDBInfo>> = MutableLiveData()

    init {
        viewModelScope.launch {
            getTMDBInfo()
        }
    }

    private suspend fun getTMDBInfo() {
        tmdbInfo.value = repoRetrofit.getTMDBInformation()
    }
}