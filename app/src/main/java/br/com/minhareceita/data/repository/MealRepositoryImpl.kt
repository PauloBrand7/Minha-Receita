package br.com.minhareceita.data.repository

import br.com.minhareceita.data.network.remote.MealCategoryRemoteDataSourceImpl
import br.com.minhareceita.domain.model.areas.AreasResponse
import br.com.minhareceita.domain.model.categories.MealsCategoryResponse
import br.com.minhareceita.domain.model.meals.MealsResponse
import br.com.minhareceita.domain.model.recipes.MealRecipeResponse
import br.com.minhareceita.domain.repository.MealCategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val foodCategoriesRemoteDataSource: MealCategoryRemoteDataSourceImpl,
) : MealCategoryRepository {

    override fun getCategories(): Flow<MealsCategoryResponse> =
        foodCategoriesRemoteDataSource.getCategories()

    override fun getAreasList(): Flow<AreasResponse> =
        foodCategoriesRemoteDataSource.getAreasList()

    override fun getMealsByCategoryName(mealCategory: String): Flow<MealsResponse> =
        foodCategoriesRemoteDataSource.getMealsByCategoryName(mealCategory)

    override fun getMealsByArea(mealArea: String): Flow<AreasResponse> =
        foodCategoriesRemoteDataSource.getMealsByArea(mealArea)

    override fun getRecipeMealById(idMeal: String): Flow<MealRecipeResponse> =
        foodCategoriesRemoteDataSource.getRecipeMealById(idMeal)
}