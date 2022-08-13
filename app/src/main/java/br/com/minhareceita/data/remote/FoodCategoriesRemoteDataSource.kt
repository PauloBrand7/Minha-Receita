package br.com.minhareceita.data.remote

import br.com.minhareceita.data.model.FoodCategoriesResponse
import br.com.minhareceita.domain.model.FoodCategories
import kotlinx.coroutines.flow.Flow

interface FoodCategoriesRemoteDataSource {

    fun getCategories(): Flow<FoodCategoriesResponse>
}