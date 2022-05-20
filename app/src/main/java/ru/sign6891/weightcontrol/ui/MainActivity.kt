package ru.sign6891.weightcontrol.ui

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.sign6891.weightcontrol.R
import ru.sign6891.weightcontrol.ui.base.OnFragmentInteractionListener

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {

    lateinit var navController: NavController
    lateinit var navHostFragment: NavHostFragment
    lateinit var navDistination: NavDestination
    lateinit var floatingActionButton: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init views test
        initViews()

    }

    private fun initViews() {
        floatingActionButton = findViewById(R.id.floatingActionButton)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController

        //Comment
        floatingActionButton.setOnClickListener {
            onClickFloatingActionButton()
        }
    }

    fun onClickFloatingActionButton() {
        navDistination = navController.currentDestination!!
        val labelDestination = navDistination.label
        when (labelDestination) {
            WeightControlFragment.NAVIGATION_LABEL -> navigateToScreen(R.id.weightControlAddFragment)
            WeightControlAddFragment.NAVIGATION_LABEL -> saveDate()
        }
    }

    fun saveDate() {
        val weightControlAddFragment: WeightControlAddFragment =
            getCurrentFragment() as WeightControlAddFragment
        weightControlAddFragment.saveDate()
    }

    fun getCurrentFragment(): androidx.fragment.app.Fragment {
        return navHostFragment.childFragmentManager.fragments.get(0)
    }

    override fun onNavigateScreen(resId: Int) {
        navigateToScreen(resId)
    }

    override fun onNavigateUpScreen() {
        navigateToPreviousScreen()
    }

    private fun navigateToPreviousScreen() {
        navController.navigateUp()
    }

    override fun onConfigureFloatingActionButton(navigationIconId: Int, fabIconId: Int) {
        if (navigationIconId > 0) {
            val drawableNavigationIcon: Drawable? =
                ContextCompat.getDrawable(this, navigationIconId)
            if (drawableNavigationIcon != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    drawableNavigationIcon.setTint(ContextCompat.getColor(this, R.color.black))
                }
            }
        }
        floatingActionButton.setImageDrawable(ContextCompat.getDrawable(this, fabIconId))
    }

    fun navigateToScreen(resId: Int) {
        navController.navigate(resId)
    }
}