package com.example.tmdbpopularmovie

import com.example.tmdbpopularmovie.data.room.repository.MoviesRepositoryImpl

lateinit var APP: MainActivity
const val BASE_IMG_URL = "https://image.tmdb.org/t/p/w500/"
const val BASE_URL = "https://api.themoviedb.org/"
lateinit var REALIZATIONDB: MoviesRepositoryImpl