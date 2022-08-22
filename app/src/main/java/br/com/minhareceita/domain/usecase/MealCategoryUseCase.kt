package br.com.minhareceita.domain.usecase

import br.com.minhareceita.data.repository.MealRepositoryImpl
import br.com.minhareceita.domain.model.areas.AreasResponse
import br.com.minhareceita.domain.model.categories.MealCategory
import br.com.minhareceita.domain.model.categories.MealsCategoryResponse
import br.com.minhareceita.domain.model.meals.MealsResponse
import br.com.minhareceita.domain.model.recipes.MealRecipeResponse
import kotlinx.coroutines.flow.Flow

class MealCategoryUseCase(
    private val repositoryImpl: MealRepositoryImpl
) {

    fun getCategories(): Flow<MealsCategoryResponse> {
        return repositoryImpl.getCategories()
    }

    fun getAreasList(): Flow<AreasResponse> {
        return repositoryImpl.getAreasList()
    }

    fun getMealsByCategoryName(mealCategory: MealCategory): Flow<MealsResponse> {
        return repositoryImpl.getMealsByCategoryName(mealCategory.categoryName)
    }

    fun getMealsByArea(mealArea: String): Flow<AreasResponse> {
        return repositoryImpl.getMealsByArea(mealArea)
    }

    fun getRecipeMealById(idMeal: String): Flow<MealRecipeResponse> {
        return repositoryImpl.getRecipeMealById(idMeal)
    }
}