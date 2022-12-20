package com.gorodechnyj.moviedb.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import com.gorodechnyj.core.navigation.Router
import com.gorodechnyj.moviedb.R
import com.gorodechnyj.moviedb.databinding.ActivityMainBinding
import com.gorodechnyj.moviedb.navigation.MainActivityNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var navigator: MainActivityNavigator

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.main_host)
        navigator = MainActivityNavigator(navController)
        router.bind(navigator)
    }

    override fun onDestroy() {
        router.unbind(navigator)
        super.onDestroy()
    }
}
