package br.com.minhareceita.mealDetails.domain.repository

import br.com.minhareceita.core.NetworkCallback
import br.com.minhareceita.meal.domain.model.MealsResponse

interface IMealDetailsRepository {
    fun getMealDetail(recipeId: String, callback: NetworkCallback<MealsResponse>)
}