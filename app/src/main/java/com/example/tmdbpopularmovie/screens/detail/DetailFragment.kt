package com.example.tmdbpopularmovie.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmdbpopularmovie.R
import com.example.tmdbpopularmovie.databinding.FragmentDetailBinding
import com.example.tmdbpopularmovie.databinding.FragmentFavoriteBinding
import com.example.tmdbpopularmovie.screens.favorites.FavoriteFragmentViewModel

class DetailFragment : Fragment() {
    private var mBinding: FragmentDetailBinding? = null
    private val binding get() = mBinding!!
    lateinit var viewMode: DetailFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

}