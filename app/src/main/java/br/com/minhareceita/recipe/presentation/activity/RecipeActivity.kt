package br.com.minhareceita.recipe.presentation.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.minhareceita.R
import br.com.minhareceita.recipe.presentation.viewmodel.RecipesViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeActivity : AppCompatActivity() {

    private val viewModel: RecipesViewModel by viewModels()
    private var query: String? = null
    private lateinit var title: TextView
    private lateinit var prepare: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_activity)
        initProperties()
    }

    private fun initProperties() {
        supportActionBar?.hide()
        title = findViewById(R.id.recipe_title)
        imageView = findViewById(R.id.recipe_image)
        prepare = findViewById(R.id.prepare)
        query = intent.getStringExtra("RECIPEID")
    }

    override fun onResume() {
        super.onResume()
        query?.let { viewModel.getRecipes(it) }
        fillRecipe()
    }

    private fun fillRecipe() {
        viewModel.ingredients.observe(this) { meal ->
            meal[0].apply {
                title.text = name
                Glide.with(this@RecipeActivity).load(image).into(imageView)
                prepare.text = instructions
            }
        }
    }
}