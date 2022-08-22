package br.com.minhareceita.data.network.remote

import br.com.minhareceita.data.network.api.MealAPI
import br.com.minhareceita.domain.model.areas.AreasResponse
import br.com.minhareceita.domain.model.categories.MealsCategoryResponse
import br.com.minhareceita.domain.model.meals.MealsResponse
import br.com.minhareceita.domain.model.recipes.MealRecipeResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MealCategoryRemoteDataSourceImpl @Inject constructor(
    private val mealAPI: MealAPI,
) {

    fun getCategories(): Flow<MealsCategoryResponse> = flow {
        emit(mealAPI.getCategories())
    }

    fun getAreasList(): Flow<AreasResponse> = flow {
        emit(mealAPI.getAreasList())
    }

    fun getMealsByCategoryName(mealCategory: String): Flow<MealsResponse> = flow {
        emit(mealAPI.getMealsByCategoryName(mealCategory))
    }

    fun getMealsByArea(mealArea: String): Flow<AreasResponse> = flow {
        emit(mealAPI.getMealsByArea(mealArea))
    }

    fun getRecipeMealById(idMeal: String): Flow<MealRecipeResponse> = flow {
        emit(mealAPI.getRecipeMealById(idMeal))
    }
}