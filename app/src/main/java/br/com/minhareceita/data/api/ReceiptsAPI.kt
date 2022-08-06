package br.com.minhareceita.data.api

import br.com.minhareceita.data.model.FoodCategoriesResponse
import retrofit2.http.GET

interface ReceiptsAPI {

    @GET("/categories.php")
    suspend fun getCategories(): FoodCategoriesResponse
}