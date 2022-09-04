package br.com.minhareceita.category.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.minhareceita.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealCategoryActivity : AppCompatActivity() {

    private val viewModel: MealCategoryViewModel by viewModels()
    private lateinit var recycleView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meal_category_activity)
        initProperties()
    }

    private fun initProperties() {
        recycleView = findViewById(R.id.categories_list)
        recycleView.layoutManager = StaggeredGridLayoutManager( 2, StaggeredGridLayoutManager.VERTICAL)

        viewModel.listOfCategories.observe(this) { list ->
            recycleView.adapter = MealCategoryRecyclerAdapter(list)
        }
    }

}