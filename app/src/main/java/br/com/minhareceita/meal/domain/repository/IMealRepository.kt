package br.com.minhareceita.meal.domain.repository

import br.com.minhareceita.meal.domain.model.MealsResponse

interface IMealRepository {
    suspend fun getMeals(mealCategoryName: String): MealsResponse
}