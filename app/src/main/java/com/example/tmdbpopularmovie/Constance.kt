package com.example.tmdbpopularmovie

import com.example.tmdbpopularmovie.data.room.repository.RoomRepositoryRealisation

lateinit var APP: MainActivity
lateinit var REALISATION_DB: RoomRepositoryRealisation
const val BASE_IMG_URL = "https://image.tmdb.org/t/p/w500/"
const val BASE_URL = "https://api.themoviedb.org/"


const val URL = "https://api.themoviedb.org/3/movie/popular?api_key=cafa669d828b93b4e5f024b227e17c34&language=en-US&page=1"