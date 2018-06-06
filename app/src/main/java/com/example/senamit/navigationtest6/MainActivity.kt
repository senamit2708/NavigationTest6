package com.example.senamit.navigationtest6

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    private var drawerLayout: DrawerLayout?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
//        supportActionBar?.run { setDisplayHomeAsUpEnabled(true)
//        setHomeButtonEnabled(true)}

        val host: NavHostFragment =
                supportFragmentManager
                        .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment? ?: return

        val navController = host.navController

        setupActionBar(navController)

    }
    private fun setupActionBar(navController: NavController) {
        drawerLayout = findViewById(R.id.drawer_layout)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
    }

        override fun onSupportNavigateUp(): Boolean {
            return NavigationUI.navigateUp(drawerLayout,
                    Navigation.findNavController(this, R.id.my_nav_host_fragment))
        }







}
