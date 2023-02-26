package br.com.minhareceita.category.domain.repository

import br.com.minhareceita.category.domain.model.MealCategoriesResponse
import br.com.minhareceita.core.NetworkCallback

interface IMealCategoryRepository {
    fun getCategories(callback: NetworkCallback<MealCategoriesResponse>)
}