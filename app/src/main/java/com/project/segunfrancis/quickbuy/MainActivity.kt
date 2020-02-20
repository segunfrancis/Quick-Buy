package com.project.segunfrancis.quickbuy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {
    /**
     * Callback for when the [.getCurrentDestination] or its arguments change.
     * This navigation may be to a destination that has not been seen before, or one that
     * was previously on the back stack. This method is called after navigation is complete,
     * but associated transitions may still be playing.
     *
     * @param controller the controller that navigated
     * @param destination the new destination
     * @param arguments the arguments passed to the destination
     */
    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        when (destination.id) {
            R.id.homeFragment -> hideActionBar()
            else -> showActionBar()
        }
    }

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = this.findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        navController.addOnDestinationChangedListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    private fun hideActionBar() {
        supportActionBar?.hide()
    }

    private fun showActionBar() {
        supportActionBar?.show()
    }
}
