package com.example.tmdbpopularmovie.screens

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbpopularmovie.BASE_IMG_URL
import com.example.tmdbpopularmovie.R
import com.example.tmdbpopularmovie.databinding.ItemLayoutBinding
import com.example.tmdbpopularmovie.models.MovieItem
import com.squareup.picasso.Picasso

class MainAdapter : ListAdapter<MovieItem, MainAdapter.MainViewHolder>(DiffUtilItemCallBack()) {

    var onClickListener: ((MovieItem) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.itemDate.text = item.release_date
        holder.binding.itemTitle.text = item.title
        Picasso.get()
            .load(BASE_IMG_URL + item.poster_path)
            .centerCrop()
            .resize(300, 300)
            .into(holder.binding.itemImage)
        holder.itemView.setOnClickListener {
            onClickListener?.invoke(item)
        }
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemLayoutBinding.bind(itemView)

    }
}