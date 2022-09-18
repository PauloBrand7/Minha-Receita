package br.com.minhareceita.meal.data.repository

import br.com.minhareceita.meal.data.api.MealAPI
import br.com.minhareceita.meal.domain.model.MealsResponse
import br.com.minhareceita.meal.domain.repository.IMealRepository
import javax.inject.Inject

class MealRepository @Inject constructor(
    private val mealApiService: MealAPI
) : IMealRepository {
    override suspend fun getMeals(mealCategoryName: String): MealsResponse {
        return mealApiService.getMealsByCategoryName(mealCategoryName)
    }
}