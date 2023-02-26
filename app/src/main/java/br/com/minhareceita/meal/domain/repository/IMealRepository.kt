package br.com.minhareceita.meal.domain.repository

import br.com.minhareceita.core.NetworkCallback
import br.com.minhareceita.meal.domain.model.MealsResponse

interface IMealRepository {
    fun getMeals(mealCategoryName: String, callback: NetworkCallback<MealsResponse>)
}