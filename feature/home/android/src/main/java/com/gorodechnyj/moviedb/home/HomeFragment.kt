package com.gorodechnyj.moviedb.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gorodechnyj.moviedb.home.databinding.FragmentHomeBinding
import com.redmadrobot.extensions.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()
    private val binding: FragmentHomeBinding by viewBinding()
}
