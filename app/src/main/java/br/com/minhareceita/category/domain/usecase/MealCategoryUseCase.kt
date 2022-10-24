package br.com.minhareceita.category.domain.usecase

import br.com.minhareceita.category.data.repository.MealCategoryRepository
import br.com.minhareceita.category.domain.model.MealCategoriesResponse
import br.com.minhareceita.category.domain.model.MealCategory
import javax.inject.Inject

class MealCategoryUseCase @Inject constructor(
    private val repository: MealCategoryRepository
) {
    suspend fun getCategories(): List<MealCategory> {
        return repository.getCategories().categories
    }
}