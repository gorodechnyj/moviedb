package com.gorodechnyj.moviedb.ui.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.gorodechnyj.moviedb.R
import com.gorodechnyj.moviedb.databinding.FragmentMenuBinding
import com.redmadrobot.extensions.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment(R.layout.fragment_menu) {

    private lateinit var navController: NavController

    private val binding: FragmentMenuBinding by viewBinding()
    private val viewModel: MenuViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController =
            (childFragmentManager.findFragmentById(R.id.menu_host) as NavHostFragment)
                .navController
        binding.navView.setupWithNavController(navController)
    }
}
