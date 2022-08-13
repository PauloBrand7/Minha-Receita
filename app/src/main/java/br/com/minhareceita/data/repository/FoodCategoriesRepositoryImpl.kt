package br.com.minhareceita.data.repository

import br.com.minhareceita.data.remote.FoodCategoriesRemoteDataSource
import br.com.minhareceita.domain.model.FoodCategories
import br.com.minhareceita.domain.repository.FoodCategoriesRepository
import br.com.minhareceita.mapping.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FoodCategoriesRepositoryImpl(
    private val foodCategoriesRemoteDataSource: FoodCategoriesRemoteDataSource,
) : FoodCategoriesRepository {

    override fun getCategories(): Flow<FoodCategories> {
        return foodCategoriesRemoteDataSource.getCategories().map { foodCategoriesResponse ->
            foodCategoriesResponse.map()
        }
    }
}