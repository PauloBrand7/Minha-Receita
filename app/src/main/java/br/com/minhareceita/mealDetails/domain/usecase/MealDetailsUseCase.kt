package br.com.minhareceita.mealDetails.domain.usecase

import br.com.minhareceita.mealDetails.data.repository.MealDetailsRepository
import br.com.minhareceita.meal.domain.model.Meal
import br.com.minhareceita.meal.domain.model.MealsResponse
import javax.inject.Inject

class MealDetailsUseCase @Inject constructor(
    private val repository: MealDetailsRepository
) {
    suspend fun getMealById(recipeId: String): Meal? {
        return repository.getMealDetail(recipeId).meals.takeIf { it.isNotEmpty() }?.let { it[0] }
    }
}