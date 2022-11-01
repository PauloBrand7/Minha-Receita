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
        viewModel.mealId = intent.getStringExtra(MealsRecyclerAdapter.TAG).toString()
        viewModel.mealDetails.observe(this@MealDetailsActivity) {
            it.meals[0].apply {
                Glide.with(this@MealDetailsActivity).load(image).into(binding.mealImage)
                adapter.updateList(details())
                binding.prepare.text = instructions
                binding.area.text = getString(R.string.txt_area) + area
                binding.mealTitle.text = name
                youtube?.apply {
                    binding.youtubeButton.visibility = View.GONE
                    youtubeUri = this
                }
            }
        }
    }
}