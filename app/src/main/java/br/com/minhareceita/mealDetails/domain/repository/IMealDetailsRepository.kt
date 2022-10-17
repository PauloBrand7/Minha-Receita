package br.com.minhareceita.mealDetails.domain.repository

import br.com.minhareceita.meal.domain.model.MealsResponse

interface IMealDetailsRepository {
    suspend fun getRecipes(recipeId: String): MealsResponse
}