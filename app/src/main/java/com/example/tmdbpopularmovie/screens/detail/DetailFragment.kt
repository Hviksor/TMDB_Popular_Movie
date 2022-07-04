package com.example.tmdbpopularmovie.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.tmdbpopularmovie.APP
import com.example.tmdbpopularmovie.BASE_IMG_URL
import com.example.tmdbpopularmovie.R
import com.example.tmdbpopularmovie.SaveShared
import com.example.tmdbpopularmovie.databinding.FragmentDetailBinding
import com.example.tmdbpopularmovie.models.MovieItem
import com.example.tmdbpopularmovie.screens.main.MainFragment
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {
    private var isFavorite = false
    private lateinit var currentMovieItem: MovieItem
    private var mBinding: FragmentDetailBinding? = null
    private val binding get() = mBinding!!
    lateinit var viewModel: DetailFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailBinding.inflate(inflater, container, false)
        hasOptionsMenu()
        currentMovieItem = arguments?.getSerializable(MainFragment.EXTRA_MOVIE) as MovieItem
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isFavorite = SaveShared.getFavorite(APP, currentMovieItem.id)
        viewModel = ViewModelProvider(this)[DetailFragmentViewModel::class.java]
        initFields()
    }

    private fun initFields() {
        if (!isFavorite) {
            binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        } else {
            binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
        Picasso.get()
            .load(BASE_IMG_URL + currentMovieItem.poster_path)
            .centerCrop()
            .resize(300, 300)
            .into(binding.imgDetail)
        binding.tvDate.text = currentMovieItem.release_date
        binding.tvTitle.text = currentMovieItem.title
        binding.tvDescription.text = currentMovieItem.overview
        binding.imgDetail.setOnClickListener {
            isFavorite = if (!isFavorite) {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                SaveShared.setFavorite(APP, currentMovieItem.id, !isFavorite)
                viewModel.insert(currentMovieItem) {}
                true
            } else {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                SaveShared.setFavorite(APP, currentMovieItem.id, !isFavorite)
                viewModel.delete(currentMovieItem) {}
                false
            }
        }
    }

}