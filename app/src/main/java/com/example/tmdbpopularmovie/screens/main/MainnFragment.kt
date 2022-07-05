package com.example.tmdbpopularmovie.screens.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbpopularmovie.databinding.FragmentMainnBinding
import com.example.tmdbpopularmovie.screens.MainAdapter

class MainnFragment : Fragment() {
    private var mBinding: FragmentMainnBinding? = null
    private val binding get() = mBinding!!
    private lateinit var rcView: RecyclerView
    private lateinit var mainAdapter: MainAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentMainnBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        initeFields()
    }

    private fun initeFields() {
        val movieList = viewModel.tmdbInfo.observe(viewLifecycleOwner) {
            Log.e("movieList", it.body()?.results.toString())
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}