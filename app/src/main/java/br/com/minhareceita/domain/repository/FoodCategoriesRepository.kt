package br.com.minhareceita.domain.repository

import br.com.minhareceita.domain.model.FoodCategories
import kotlinx.coroutines.flow.Flow

interface FoodCategoriesRepository {

    fun getCategories(): Flow<FoodCategories>
}