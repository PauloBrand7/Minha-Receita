package br.com.minhareceita.recipe.domain.repository

import br.com.minhareceita.meal.domain.model.MealsResponse

interface IRecipeRepository {
    suspend fun getRecipes(recipeId: String): MealsResponse
}