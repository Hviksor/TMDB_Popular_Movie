package com.example.tmdbpopularmovie.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmdbpopularmovie.R
import com.example.tmdbpopularmovie.databinding.FragmentMainnBinding

class MainnFragment : Fragment() {
    private var mBinding: FragmentMainnBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentMainnBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initeFields()
    }

    private fun initeFields() {
        TODO("Not yet implemented")
    }


    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}