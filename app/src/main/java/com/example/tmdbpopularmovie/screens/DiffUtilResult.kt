package com.example.tmdbpopularmovie.screens

import androidx.recyclerview.widget.DiffUtil
import com.example.tmdbpopularmovie.model.MovieItem

class DiffUtilResult : DiffUtil.ItemCallback<MovieItem>() {
    override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
        return oldItem == newItem
    }

}