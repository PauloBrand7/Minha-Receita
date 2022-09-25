package br.com.minhareceita.recipe.domain.usecase

import br.com.minhareceita.recipe.data.repository.RecipeRepository
import br.com.minhareceita.meal.domain.model.Meal
import javax.inject.Inject

class RecipesUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    suspend fun getRecipesById(recipeId: String): ArrayList<Meal> {
        return repository.getRecipes(recipeId).meals
    }
}