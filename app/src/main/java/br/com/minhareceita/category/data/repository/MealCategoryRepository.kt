package br.com.minhareceita.category.data.repository

import br.com.minhareceita.category.data.api.MealCategoryAPI
import br.com.minhareceita.category.domain.model.MealCategoriesResponse
import br.com.minhareceita.category.domain.repository.IMealCategoryRepository
import dagger.Component
import javax.inject.Inject

class MealCategoryRepository @Inject constructor(
    private val mealCategoryApiService: MealCategoryAPI,
) : IMealCategoryRepository {

    override suspend fun getCategories(): MealCategoriesResponse {
        return mealCategoryApiService.getCategories()
    }

}