package br.com.minhareceita.mealDetails.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.minhareceita.R
import br.com.minhareceita.core.details
import br.com.minhareceita.databinding.MealDetailActivityBinding
import br.com.minhareceita.meal.domain.model.Meal
import br.com.minhareceita.meal.presentation.MealsRecyclerAdapter
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MealDetailsActivity : AppCompatActivity() {

    private val viewModel: MealDetailsViewModel by viewModels()
    private lateinit var binding: MealDetailActivityBinding
    private var adapter = MealDetailsRecyclerAdapter()
    private var youtubeUri = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MealDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initProperties()
    }

    private fun initProperties() {
        supportActionBar?.hide()
        viewModel.mealId = intent.getStringExtra(MealsRecyclerAdapter.TAG).toString()
        binding.apply {
            ingredientsList.layoutManager =
                LinearLayoutManager(this@MealDetailsActivity, LinearLayoutManager.VERTICAL, false)
            ingredientsList.adapter = adapter
            youtubeButton.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUri)))
            }
        }
    }

    override fun onResume() {
        super.onResume()
        fillMealDetails()
    }

    private fun fillMealDetails() {
        viewModel.mealDetails.observe(this@MealDetailsActivity) { meal ->
            bindingValues(meal)
        }
    }

    private fun bindingValues(meal: Meal) {
        binding.apply {
            Glide.with(this@MealDetailsActivity).load(meal.image).into(mealImage)
            prepare.text = meal.instructions
            area.text = getString(R.string.txt_area) + meal.area
            mealTitle.text = meal.name
            meal.youtube?.let {
                youtubeButton.visibility = View.VISIBLE
                youtubeUri = it
            }
            adapter.updateList(meal.details())
        }
    }
}