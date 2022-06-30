package com.example.tmdbpopularmovie.screens.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbpopularmovie.R
import com.example.tmdbpopularmovie.databinding.FragmentFavoriteBinding
import com.example.tmdbpopularmovie.databinding.FragmentMainBinding
import com.example.tmdbpopularmovie.screens.MainAdapter
import com.example.tmdbpopularmovie.screens.main.MainFragmentViewMode

class FavoriteFragment : Fragment() {
    private var mBinding: FragmentFavoriteBinding? = null
    private val binding get() = mBinding!!

    private lateinit var mainAdapter: MainAdapter
    private lateinit var rcView: RecyclerView
    lateinit var viewMode: FavoriteFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewMode = ViewModelProvider(this)[FavoriteFragmentViewModel::class.java]
        initFields()
    }

    private fun initFields() {
        rcView = binding.rcViewFavorite
        mainAdapter = MainAdapter()
        rcView.adapter = mainAdapter
    }


    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }


}