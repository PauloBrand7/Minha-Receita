package br.com.minhareceita.mealDetails.domain.usecase

import br.com.minhareceita.mealDetails.data.repository.MealDetailsRepository
import br.com.minhareceita.meal.domain.model.Meal
import javax.inject.Inject

class MealDetailsUseCase @Inject constructor(
    private val repository: MealDetailsRepository
) {
    suspend fun getRecipesById(recipeId: String): List<Meal> {
        return repository.getRecipes(recipeId).meals
    }
}