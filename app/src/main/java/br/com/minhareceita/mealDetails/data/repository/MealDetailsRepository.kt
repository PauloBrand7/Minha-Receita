package br.com.minhareceita.mealDetails.data.repository

import br.com.minhareceita.meal.domain.model.MealsResponse
import br.com.minhareceita.mealDetails.data.api.MealDetailsAPI
import br.com.minhareceita.mealDetails.domain.repository.IMealDetailsRepository
import javax.inject.Inject

class MealDetailsRepository @Inject constructor(
    private val mealDetailsApiService: MealDetailsAPI,
) : IMealDetailsRepository {

    override suspend fun getMealDetail(recipeId: String): MealsResponse {
        return mealDetailsApiService.getMealDetailsById(recipeId)
    }
}