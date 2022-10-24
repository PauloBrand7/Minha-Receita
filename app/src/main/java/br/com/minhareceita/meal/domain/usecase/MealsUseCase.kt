package br.com.minhareceita.meal.domain.usecase

import br.com.minhareceita.meal.data.repository.MealRepository
import br.com.minhareceita.meal.domain.model.Meal
import javax.inject.Inject

class MealsUseCase @Inject constructor(
    private val repository: MealRepository
) {
    suspend fun getMealsByCategoryName(mealCategoryName: String): List<Meal> {
        return repository.getMeals(mealCategoryName).meals
    }
}