package com.example.tmdbpopularmovie.screens.detail

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.example.tmdbpopularmovie.APP
import com.example.tmdbpopularmovie.BASE_IMG_URL
import com.example.tmdbpopularmovie.MainActivity
import com.example.tmdbpopularmovie.R
import com.example.tmdbpopularmovie.databinding.FragmentDetailBinding
import com.example.tmdbpopularmovie.model.MovieItem
import com.example.tmdbpopularmovie.screens.main.MainnFragment
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {
    private var movieId: Int = MOVIE_ID_DEFAULT
    private var mBinding: FragmentDetailBinding? = null
    private val binding get() = mBinding!!
    private lateinit var viewModel: DetailViewModel
    private lateinit var menuHost: MenuHost
    private var isFavorite = false
    private lateinit var movieItemTemp: MovieItem
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
        initOnClickFavorite()

    }

    private fun initOnClickFavorite() {
        viewModel.getSingleMovieInfoTMDB(movieId)
        viewModel.chekFavorite(movieId)

        viewModel.isFavorite.observe(viewLifecycleOwner) {

            isFavorite = if (it) {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                true
            } else {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                false
            }
        }

        binding.imgDetailFavorite.setOnClickListener {

            isFavorite = if (isFavorite) {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                viewModel.deleteToFavorite(movieItemTemp) {}
                false
            } else {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                viewModel.addToFavorite(movieItemTemp) {}
                true
            }
        }
    }

    private fun activateMenu() {
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.title = "Detail Movie"
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

    private fun initFields() {
        viewModel.getSingleMovieInfoTMDB(movieId)
        viewModel.singleMovieInfo.observe(viewLifecycleOwner) { it ->
            it.body()?.let {
                movieItemTemp = it
            }
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