package br.com.minhareceita.category.domain.repository

import br.com.minhareceita.category.domain.model.MealCategoriesResponse

interface IMealCategoryRepository {
    suspend fun getCategories(): MealCategoriesResponse
}