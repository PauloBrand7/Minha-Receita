package br.com.minhareceita.domain.repository

import br.com.minhareceita.domain.model.areas.AreasResponse
import br.com.minhareceita.domain.model.categories.MealsCategoryResponse
import br.com.minhareceita.domain.model.meals.MealsResponse
import br.com.minhareceita.domain.model.recipes.MealRecipeResponse
import kotlinx.coroutines.flow.Flow

interface MealCategoryRepository {

    fun getCategories(): Flow<MealsCategoryResponse>

    fun getAreasList(): Flow<AreasResponse>

    fun getMealsByCategoryName(mealCategory: String): Flow<MealsResponse>

    fun getMealsByArea(mealArea: String): Flow<AreasResponse>

    fun getRecipeMealById(idMeal: String): Flow<MealRecipeResponse>
}