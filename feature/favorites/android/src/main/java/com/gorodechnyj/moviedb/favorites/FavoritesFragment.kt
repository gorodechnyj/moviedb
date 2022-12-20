package com.gorodechnyj.moviedb.favorites

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gorodechnyj.moviedb.favorites.databinding.FragmentFavoritesBinding
import com.gorodechnyj.moviedb.favorites.R
import com.redmadrobot.extensions.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private val viewModel: FavoritesViewModel by viewModels()
    private val binding: FragmentFavoritesBinding by viewBinding()
}
