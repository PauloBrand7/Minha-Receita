package br.com.minhareceita.core

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import br.com.minhareceita.R
import br.com.minhareceita.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.ToolBar)
        setupActionBar()
        setupNavController()
    }

    private fun setupNavController() {
        navFragment =
            supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
        navFragment.navController.setGraph(R.navigation.fragments_navigation)
        navFragment.navController.navigate(R.id.nav_category_fragment)
    }

    private fun setupActionBar() {
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
        }
        binding.backButton.setOnClickListener {
            navFragment.navController.popBackStack()
        }
    }

    override fun onResume() {
        super.onResume()

        navFragment.navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.nav_category_fragment -> {
                    binding.apply {
                        backButton.visibility = View.GONE
                        search.queryHint = getString(R.string.search_categories_text)
                        search.setQuery("",false)
                    }
                }
                R.id.nav_meal_fragment -> {
                    binding.apply {
                        backButton.visibility = View.VISIBLE
                        search.visibility = View.VISIBLE
                        search.queryHint = getString(R.string.search_meals_text)
                        search.setQuery("",false)
                    }
                }
                R.id.nav_meal_detail -> {
                    binding.search.visibility = View.GONE
                }
                R.id.nav_network_error -> {
                    binding.apply {
                        backButton.visibility = View.GONE
                        search.visibility = View.GONE
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount != 0) {
            navFragment.navController.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    fun getSearchBar() = binding.search
}