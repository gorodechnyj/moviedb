package com.gorodechnyj.moviedb.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.gorodechnyj.core.navigation.Router
import com.gorodechnyj.moviedb.R
import com.gorodechnyj.moviedb.navigation.TabNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
abstract class BottomViewTabFragment(private val start: Int) :
    Fragment(R.layout.fragment_bottom_view_tab) {

    @Inject
    lateinit var router: Router

    private lateinit var navigator: TabNavigator

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.tab_nav_host) as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.in_tab_navigation)

        graph.setStartDestination(start)

        val navController = navHostFragment.navController
        navController.setGraph(graph, null)

        navigator = TabNavigator(
            (navController.context as MainActivity).navigator,
            navController
        )
    }

    override fun onResume() {
        super.onResume()
        router.bind(navigator)
    }

    override fun onPause() {
        super.onPause()
        router.unbind(navigator)
    }
}

class HomeTabFragment : BottomViewTabFragment(R.id.home)
class CatalogTabFragment : BottomViewTabFragment(R.id.catalog)
class FavoritesTabFragment : BottomViewTabFragment(R.id.favorites)
