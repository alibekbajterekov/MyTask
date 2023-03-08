package com.example.mytask

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.mytask.utils.Preferences
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,
            R.id.navigation_profile, R.id.newTaskFragment
        ))

        if(!Preferences(applicationContext).isBoardingShowed()){
            navController.navigate(R.id.onBoardFragment)
        }



        navController.addOnDestinationChangedListener{_, destination, _ ->
            if (destination.id == R.id.newTaskFragment || destination.id == R.id.onBoardFragment) {
                navView.visibility = View.GONE
            }else{
                navView.visibility = View.VISIBLE
            }

            if(destination.id == R.id.onBoardFragment){
                supportActionBar?.hide()
            }else{
                supportActionBar?.show()
            }
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}