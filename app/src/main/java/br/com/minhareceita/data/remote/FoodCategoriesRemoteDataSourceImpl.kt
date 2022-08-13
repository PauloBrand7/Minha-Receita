package br.com.minhareceita.data.remote

import br.com.minhareceita.data.api.ReceiptsAPI
import br.com.minhareceita.data.model.FoodCategoriesResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FoodCategoriesRemoteDataSourceImpl(
    private val receiptsAPI: ReceiptsAPI,
) : FoodCategoriesRemoteDataSource {

    override fun getCategories(): Flow<FoodCategoriesResponse> = flow {
        emit(receiptsAPI.getCategories())
    }
}