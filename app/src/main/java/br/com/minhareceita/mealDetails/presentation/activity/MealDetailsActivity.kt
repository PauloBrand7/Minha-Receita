package br.com.minhareceita.mealDetails.presentation.activity

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
    }

    override fun onResume() {
        super.onResume()
        fillRecipe()
    }

    private fun fillRecipe() {
        viewModel.apply {
            mealId = intent.getStringExtra(MealsRecyclerAdapter.TAG).toString()

            ingredients.observe(this@MealDetailsActivity) { meal ->
                meal[0].apply {
                    adapter.updateList(this.details())
                    binding.recipeTitle.text = name
                    Glide.with(this@MealDetailsActivity).load(image).into(binding.recipeImage)
                    binding.prepare.text = instructions
                    binding.area.text = getString(R.string.txt_area) + area
                    binding.youtubeButton.setOnClickListener {
                        if (youtube != null) {
                            startActivity(
                                Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(youtube)
                                )
                            )
                        } else {
                            binding.youtubeButton.visibility = View.GONE
                        }
                    }
                }
            }

        }
    }
}