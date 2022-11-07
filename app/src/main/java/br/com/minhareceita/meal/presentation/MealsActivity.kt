package br.com.minhareceita.meal.presentation

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.minhareceita.R
import br.com.minhareceita.category.presentation.MealCategoryRecyclerAdapter
import br.com.minhareceita.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealsActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private val viewModel: MealsViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MealsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initProperties()
    }

    private fun initProperties() {
        supportActionBar?.hide()
        adapter = MealsRecyclerAdapter(this)
        viewModel.category = intent.getStringExtra(MealCategoryRecyclerAdapter.TAG).toString()
        binding.apply {
            backButton.visibility = View.VISIBLE
            backButton.setOnClickListener {
                onBackPressed()
            }
            search.queryHint = getString(R.string.search_meals_text)
            contentList.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            contentList.adapter = adapter
            search.setOnQueryTextListener(this@MealsActivity)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.meals.observe(this@MealsActivity) {
            adapter.updateList(it)
        }
    }

    override fun onQueryTextSubmit(searchWord: String?): Boolean {
        adapter.filter.filter(searchWord)
        return false
    }

    override fun onQueryTextChange(searchWord: String?): Boolean {
        adapter.filter.filter(searchWord)
        return false
    }
}