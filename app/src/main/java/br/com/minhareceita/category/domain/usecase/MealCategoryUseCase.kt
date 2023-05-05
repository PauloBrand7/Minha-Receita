package br.com.minhareceita.category.domain.usecase

import br.com.minhareceita.category.data.repository.MealCategoryRepository
import br.com.minhareceita.category.domain.model.MealCategoriesResponse
import br.com.minhareceita.core.NetworkCallback
import javax.inject.Inject

class MealCategoryUseCase @Inject constructor(
    private val repository: MealCategoryRepository
) {
    fun getCategories(callback: NetworkCallback<MealCategoriesResponse>) {
        repository.getCategories(callback)
    }
}