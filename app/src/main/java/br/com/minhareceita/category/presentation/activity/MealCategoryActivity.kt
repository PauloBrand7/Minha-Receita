package br.com.minhareceita.category.presentation.activity

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isEmpty
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.minhareceita.R
import br.com.minhareceita.category.presentation.adapter.MealCategoryRecyclerAdapter
import br.com.minhareceita.category.presentation.viewmodel.MealCategoryViewModel
import br.com.minhareceita.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealCategoryActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private val viewModel: MealCategoryViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MealCategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initProperties()
    }

    override fun onResume() {
        super.onResume()
        viewModel.listOfCategories.observe(this) { list ->
            binding.apply {
                if (list.isEmpty()) {
                    contentList.visibility = View.GONE
                    iconNetwork.visibility = View.VISIBLE
                    txtNetwork.visibility = View.VISIBLE
                } else {
                    contentList.visibility = View.VISIBLE
                    iconNetwork.visibility = View.GONE
                    txtNetwork.visibility = View.GONE
                }
            }
            adapter.updateList(list)
        }

    }

    private fun initProperties() {
        supportActionBar?.hide()
        binding.backButton.visibility = View.GONE
        adapter = MealCategoryRecyclerAdapter(this)
        binding.apply {
            search.queryHint = getString(R.string.search_categories_text)
            search.setOnQueryTextListener(this@MealCategoryActivity)
            contentList.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            contentList.adapter = adapter
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