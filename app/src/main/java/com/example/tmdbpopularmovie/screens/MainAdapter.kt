package com.example.tmdbpopularmovie.screens

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbpopularmovie.models.MovieItem

class MainAdapter : ListAdapter<MovieItem, MainAdapter.MainViewHolder>(DiffUtilItemCallBack()) {
    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}