package com.example.tmdbpopularmovie.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbpopularmovie.R
import com.example.tmdbpopularmovie.databinding.FragmentMainBinding
import com.example.tmdbpopularmovie.screens.MainAdapter

class MainFragment : Fragment() {
    private var mBinding: FragmentMainBinding? = null
    private val binding get() = mBinding!!

    private lateinit var mainAdapter: MainAdapter
    private lateinit var rcView: RecyclerView
    lateinit var viewMode: MainFragmentViewMode

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewMode = ViewModelProvider(this)[MainFragmentViewMode::class.java]
        initFields()
    }

    private fun initFields() {
        rcView = binding.rcViewMain
        mainAdapter = MainAdapter()
        rcView.adapter = mainAdapter
        viewMode.getMovies()
        viewMode.myMovies.observe(viewLifecycleOwner) {
            mainAdapter.submitList(it.body()?.results)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}