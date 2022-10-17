package br.com.minhareceita.mealDetails.data.repository

import br.com.minhareceita.mealDetails.data.api.MealDetailsAPI
import br.com.minhareceita.meal.domain.model.MealsResponse
import br.com.minhareceita.mealDetails.domain.repository.IMealDetailsRepository
import javax.inject.Inject

class MealDetailsRepository @Inject constructor(
    private val recipeApiService: MealDetailsAPI,
) : IMealDetailsRepository {

    override suspend fun getRecipes(recipeId: String): MealsResponse {
        return recipeApiService.getRecipeById(recipeId)
    }
}