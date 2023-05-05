package br.com.minhareceita.meal.domain.usecase

import br.com.minhareceita.core.NetworkCallback
import br.com.minhareceita.meal.data.repository.MealRepository
import br.com.minhareceita.meal.domain.model.MealsResponse
import javax.inject.Inject

class MealsUseCase @Inject constructor(
    private val repository: MealRepository
) {
    fun getMealsByCategoryName(
        mealCategoryName: String,
        callback: NetworkCallback<MealsResponse>
    ) {
        repository.getMeals(mealCategoryName, callback)
    }
}