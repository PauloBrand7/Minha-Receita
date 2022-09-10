package br.com.minhareceita.category.domain.usecase

import br.com.minhareceita.category.data.repository.MealCategoryRepository
import br.com.minhareceita.category.domain.model.MealCategoriesResponse
import br.com.minhareceita.category.domain.repository.IMealCategoryRepository
import javax.inject.Inject

class MealCategoryUseCase(
    private val repository: IMealCategoryRepository
) {
    suspend fun getCategories(): MealCategoriesResponse {
        return repository.getCategories()
    }
}