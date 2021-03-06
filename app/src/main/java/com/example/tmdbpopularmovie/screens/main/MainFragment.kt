package com.example.tmdbpopularmovie.screens.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbpopularmovie.APP
import com.example.tmdbpopularmovie.MainActivity
import com.example.tmdbpopularmovie.R
import com.example.tmdbpopularmovie.databinding.FragmentMainBinding
import com.example.tmdbpopularmovie.screens.MainAdapter

class MainFragment : Fragment() {
    private var mBinding: FragmentMainBinding? = null
    private val binding get() = mBinding!!

    private lateinit var mainAdapter: MainAdapter
    private lateinit var rcView: RecyclerView
    private lateinit var menuHost: MenuHost
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
        menuHost = requireActivity()
        initMenu()
        initFields()
        onClick()
    }

    private fun onClick() {
        mainAdapter.onClickListener = {
            val bundle = Bundle()
            bundle.putSerializable(EXTRA_MOVIE, it)
            APP.navController.navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        }
    }

    private fun initFields() {
        rcView = binding.rcViewMain
        mainAdapter = MainAdapter()
        rcView.adapter = mainAdapter
        viewMode.myMovies.observe(viewLifecycleOwner) {
            mainAdapter.submitList(it.body()?.results)
        }
    }

    private fun initMenu() {
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.main_menu, menu)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.item_favorite -> {
                        APP.navController.navigate(R.id.action_mainFragment_to_favoriteFragment)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }


    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

    companion object {
        const val EXTRA_MOVIE = "movie"
    }

}