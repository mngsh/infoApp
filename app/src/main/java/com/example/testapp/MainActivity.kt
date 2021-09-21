package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.main_activity_bottom_navigation)
        val nvController = findNavController(R.id.main_activity_navigation_fragment)

        val barConfig = AppBarConfiguration(setOf(
            R.id.mainFragment, R.id.aboutFragment
        ))

        navView.setupWithNavController(nvController)
    }
}