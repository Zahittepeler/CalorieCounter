package com.example.caloriecounter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.caloriecounter.R
import com.example.caloriecounter.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private lateinit var naviController: NavController
    private var bottomNavigationView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)




        val navHostFragment = supportFragmentManager.findFragmentById(
                R.id.fragmentContainerView
                ) as NavHostFragment
        naviController = navHostFragment.navController

        bottomNavigationView = findViewById<BottomNavigationView>(R.id.button_main_menu)
        bottomNavigationView?.setupWithNavController(naviController)

        bottomNavigationView?.itemIconTintList = null


    }

    fun setBottomNavigationVisibility(isVisible: Boolean) {
        bottomNavigationView?.isVisible = isVisible
    }


}