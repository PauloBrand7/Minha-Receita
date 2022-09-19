package br.com.minhareceita.recipe.domain.repository

import br.com.minhareceita.recipe.domain.model.RecipeIngredients

interface IRecipeRepository {
    suspend fun getRecipes(recipeId: String): ArrayList<RecipeIngredients>
}