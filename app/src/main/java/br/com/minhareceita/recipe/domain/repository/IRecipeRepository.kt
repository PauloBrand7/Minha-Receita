package br.com.minhareceita.recipe.domain.repository

import br.com.minhareceita.recipe.domain.model.RecipeResponse

interface IRecipeRepository {
    suspend fun getRecipes(recipeId: String): RecipeResponse
}