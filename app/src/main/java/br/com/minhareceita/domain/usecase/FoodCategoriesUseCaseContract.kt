package br.com.minhareceita.domain.usecase

import br.com.minhareceita.domain.model.FoodCategories
import kotlinx.coroutines.flow.Flow

interface FoodCategoriesUseCaseContract {

    fun getCategories(): Flow<FoodCategories>
}