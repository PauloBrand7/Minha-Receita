package br.com.minhareceita.mealDetails.presentation.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.minhareceita.core.details
import br.com.minhareceita.databinding.MealDetailActivityBinding
import br.com.minhareceita.meal.presentation.adapter.MealsRecyclerAdapter
import br.com.minhareceita.mealDetails.presentation.adapter.MealDetailsRecyclerAdapter
import br.com.minhareceita.mealDetails.presentation.viewmodel.MealDetailsViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MealDetailsActivity : AppCompatActivity() {

    private val viewModel: MealDetailsViewModel by viewModels()
    private lateinit var binding: MealDetailActivityBinding
    private var adapter = MealDetailsRecyclerAdapter()
    private var query: String = ""
    private var youtubeLink = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MealDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initProperties()
    }

    private fun initProperties() {
        supportActionBar?.hide()
        binding.apply {
            ingredientsList.layoutManager =
                LinearLayoutManager(this@MealDetailsActivity, LinearLayoutManager.VERTICAL, false)
            ingredientsList.adapter = adapter
        }
        query = intent.getStringExtra(MealsRecyclerAdapter.TAG).toString()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getRecipes(query)
        fillRecipe()

        binding.youtubeButton.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(youtubeLink)
                )
            )
        }
    }

    private fun fillRecipe() {
        viewModel.ingredients.observe(this) { meal ->
            meal[0].apply {
                adapter.updateList(this.details())
                binding.recipeTitle.text = name
                Glide.with(this@MealDetailsActivity).load(image).into(binding.recipeImage)
                binding.prepare.text = instructions
                if (youtube != null) {
                    youtubeLink = youtube
                }
            }
        }
    }
}