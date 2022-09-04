package br.com.minhareceita.category.data.api

import br.com.minhareceita.category.domain.model.MealCategoriesResponse
import retrofit2.http.GET

interface MealCategoryAPI {

    @GET("categories.php")
    suspend fun getCategories(): MealCategoriesResponse

}