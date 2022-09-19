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
    private lateinit var firstIngredient: TextView
    private lateinit var secondIngredient: TextView
    private lateinit var thirdIngredient: TextView
    private lateinit var fourthIngredient: TextView
    private lateinit var fifthIngredient: TextView
    private lateinit var prepare: TextView
    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_activity)
        initProperties()
    }

    private fun initProperties() {
        supportActionBar?.hide()
        title = findViewById(R.id.recipe_title)
        image = findViewById(R.id.recipe_image)
        firstIngredient = findViewById(R.id.ingredient1)
        secondIngredient = findViewById(R.id.ingredient2)
        thirdIngredient = findViewById(R.id.ingredient3)
        fourthIngredient = findViewById(R.id.ingredient4)
        fifthIngredient = findViewById(R.id.ingredient5)
        prepare = findViewById(R.id.prepare)
        query = intent.getStringExtra("RECIPEID")
    }

    override fun onResume() {
        super.onResume()
        query?.let { viewModel.getRecipes(it) }
        fillRecipe()
    }

    private fun fillRecipe() {
        viewModel.ingredients.observe(this) { recipe ->
            recipe[0].apply {
                title.text = mealName
                Glide.with(this@RecipeActivity).load(strMealThumb).into(image)
                firstIngredient.text = ingredient1
                secondIngredient.text = ingredient2
                thirdIngredient.text = ingredient3
                fourthIngredient.text = ingredient4
                fifthIngredient.text = ingredient5
                prepare.text = strInstructions
            }
        }
    }
}