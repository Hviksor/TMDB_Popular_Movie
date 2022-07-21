package com.example.tmdbpopularmovie.screens.main

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbpopularmovie.APP
import com.example.tmdbpopularmovie.MainActivity
import com.example.tmdbpopularmovie.R
import com.example.tmdbpopularmovie.databinding.FragmentMainnBinding
import com.example.tmdbpopularmovie.screens.MainAdapter

class MainnFragment : Fragment() {
    private var mBinding: FragmentMainnBinding? = null
    private val binding get() = mBinding!!
    private lateinit var rcView: RecyclerView
    private lateinit var mainAdapter: MainAdapter
    private lateinit var menuHost: MenuHost
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        menuHost = requireActivity()
        initMenu()
    }

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

        initFields()
        onClick()
    }

    private fun initMenu() {

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.main_menu, menu)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.favorite -> {
                        APP.navController.navigate(R.id.action_mainnFragment_to_favoritesFragment)
                        true
                    }
                    else -> false
                }

            }
        })
    }


    private fun initFields() {
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as MainActivity).supportActionBar?.title = "Popular Movies"
        rcView = binding.rcView
        mainAdapter = MainAdapter()
        rcView.adapter = mainAdapter
        viewModel.tmdbInfo.observe(viewLifecycleOwner) {
            mainAdapter.submitList(it.body()?.results)
        }
    }

    private fun onClick() {
        mainAdapter.onClickItem = {
            val bundle = Bundle()
            it.id?.let { it1 -> bundle.putInt(MOVIE_ID, it1) }
            APP.navController.navigate(R.id.action_mainnFragment_to_detailFragment2, bundle)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

    companion object {
        const val MOVIE_ID = "movie_id"
    }

}