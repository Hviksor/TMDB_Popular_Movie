package com.example.tmdbpopularmovie.screens.detail

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.tmdbpopularmovie.BASE_IMG_URL
import com.example.tmdbpopularmovie.MainActivity
import com.example.tmdbpopularmovie.R
import com.example.tmdbpopularmovie.databinding.FragmentDetailBinding
import com.example.tmdbpopularmovie.screens.main.MainnFragment
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {
    private var movieId: Int = MOVIE_ID_DEFAULT
    private var mBinding: FragmentDetailBinding? = null
    private val binding get() = mBinding!!
    private lateinit var viewModel: DetailViewModel
    private lateinit var menuHost: MenuHost
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        menuHost = requireActivity()
        activateMenu()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        getMovieId()

        initFields()
    }

    private fun activateMenu() {

        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.title = "Favorite Movie"

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                TODO("Not yet implemented")
            }

        })
    }

    private fun initFields() {
        viewModel.getSingleMovieInfo(movieId)
        viewModel.singleMovieInfo.observe(viewLifecycleOwner) {
            val movieItemTemp = it.body()
            binding.tvDate.text = movieItemTemp?.release_date
            binding.tvDescription.text = movieItemTemp?.overview
            binding.tvTitle.text = movieItemTemp?.title
            Picasso.get()
                .load(BASE_IMG_URL + movieItemTemp?.poster_path)
                .centerCrop()
                .resize(400, 400)
                .into(binding.imgDetail)
        }
    }

    private fun getMovieId() {
        val args = requireArguments()
        if (!args.containsKey(MainnFragment.MOVIE_ID)) {
            throw RuntimeException("Movie_ID is empty")
        }
        val id: Int = args.getInt(MainnFragment.MOVIE_ID, MOVIE_ID_DEFAULT)
        if (id > 0) {
            movieId = id
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

    companion object {
        const val MOVIE_ID_DEFAULT = -1
    }
}