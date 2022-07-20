package com.example.tmdbpopularmovie.screens.favorite

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbpopularmovie.APP
import com.example.tmdbpopularmovie.MainActivity
import com.example.tmdbpopularmovie.R
import com.example.tmdbpopularmovie.databinding.FragmentDetailBinding
import com.example.tmdbpopularmovie.databinding.FragmentFavoritesBinding
import com.example.tmdbpopularmovie.screens.MainAdapter

class FavoritesFragment : Fragment() {
    private var mBinding: FragmentFavoritesBinding? = null
    private val binding get() = mBinding!!
    private lateinit var menuHost: MenuHost
    private lateinit var rcView: RecyclerView
    private lateinit var mainAdapter: MainAdapter
    private lateinit var viewModel: FavoriteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        menuHost = requireActivity()
        activateMenu()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentFavoritesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[FavoriteViewModel::class.java]
        initFields()
    }

    private fun initFields() {
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.title = "Favorite Movies"
        rcView = binding.rcView
        mainAdapter = MainAdapter()
        rcView.adapter = mainAdapter
        viewModel.getAllFavoritesMovie().observe(viewLifecycleOwner) {
            mainAdapter.submitList(it.asReversed())
        }

    }


    private fun activateMenu() {

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    android.R.id.home -> {
                        APP.navController.popBackStack()
//                        requireActivity().supportFragmentManager.beginTransaction()
                        true
                    }
                    else -> false

                }
            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}