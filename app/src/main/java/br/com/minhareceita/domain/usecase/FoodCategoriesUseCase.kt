package br.com.minhareceita.domain.usecase

import br.com.minhareceita.data.repository.FoodCategoriesRepositoryImpl
import br.com.minhareceita.domain.model.FoodCategories
import kotlinx.coroutines.flow.Flow

class FoodCategoriesUseCase(
    private val repositoryImpl: FoodCategoriesRepositoryImpl
): FoodCategoriesUseCaseContract {

    override fun getCategories(): Flow<FoodCategories> {
        return repositoryImpl.getCategories()
    }
}