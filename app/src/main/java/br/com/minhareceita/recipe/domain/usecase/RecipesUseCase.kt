package br.com.minhareceita.recipe.domain.usecase

import br.com.minhareceita.recipe.data.repository.RecipeRepository
import br.com.minhareceita.recipe.domain.model.RecipeIngredients
import br.com.minhareceita.recipe.domain.model.RecipeResponse
import javax.inject.Inject

class RecipesUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    suspend fun getRecipesById(recipeId: String): ArrayList<RecipeIngredients> {
        return repository.getRecipes(recipeId).recipes
    }
}