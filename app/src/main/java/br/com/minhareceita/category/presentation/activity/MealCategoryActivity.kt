package br.com.minhareceita.category.presentation.activity

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.minhareceita.R
import br.com.minhareceita.category.presentation.adapter.MealCategoryRecyclerAdapter
import br.com.minhareceita.category.presentation.viewmodel.MealCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealCategoryActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private val viewModel: MealCategoryViewModel by viewModels()
    private lateinit var recycleView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var title: TextView
    private lateinit var adapter: MealCategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meal_category_activity)
        initProperties()
    }

    private fun initProperties() {
        supportActionBar?.hide()
        title = findViewById(R.id.title_appbar)

        recycleView = findViewById(R.id.categories_list)
        recycleView.layoutManager = StaggeredGridLayoutManager( 2, StaggeredGridLayoutManager.VERTICAL)

        searchView = findViewById(R.id.category_search)
        searchView.setOnSearchClickListener {
            title.visibility = View.GONE
        }

        searchView.setOnQueryTextListener(this)

        viewModel.listOfCategories.observe(this) { list ->
            adapter = MealCategoryRecyclerAdapter(this, list)
            recycleView.adapter = adapter
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