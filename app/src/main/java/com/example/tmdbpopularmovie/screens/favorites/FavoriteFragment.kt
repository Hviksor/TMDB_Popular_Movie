package com.example.tmdbpopularmovie.screens.favorites

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
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
        hasOptionsMenu()
        initMenu()
        return binding.root
    }

    private fun initMenu() {
        val menuHost = requireActivity()
        menuHost.addMenuProvider(object :MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                TODO("Not yet implemented")
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                TODO("Not yet implemented")
            }
        })
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
        viewMode.getAllMovies().observe(viewLifecycleOwner) {
            mainAdapter.submitList(it.asReversed())
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }


}