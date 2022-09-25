package br.com.minhareceita.meal.presentation.activity

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.minhareceita.R
import br.com.minhareceita.meal.presentation.adapter.MealsRecyclerAdapter
import br.com.minhareceita.meal.presentation.viewmodel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealsActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private val viewModel: MealsViewModel by viewModels()
    private var query: String? = null
    private lateinit var recycleView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var title: TextView
    private lateinit var adapter: MealsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meal_activity)
        initProperties()
    }

    private fun initProperties() {
        supportActionBar?.hide()
        title = findViewById(R.id.title_appbar)

        recycleView = findViewById(R.id.meals_list)
        recycleView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        searchView = findViewById(R.id.meals_search)
        searchView.setOnSearchClickListener {
            title.visibility = View.GONE
        }

        searchView.setOnQueryTextListener(this)
        query = intent.getStringExtra("CATEGORYNAME")
    }

    override fun onResume() {
        super.onResume()
        viewModel.listOfMeals.observe(this) { list ->
            adapter = MealsRecyclerAdapter(this, list)
            recycleView.adapter = adapter
        }

        query?.let { viewModel.getMeals(it) }
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