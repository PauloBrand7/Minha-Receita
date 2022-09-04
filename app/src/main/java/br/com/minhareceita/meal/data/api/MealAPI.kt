package br.com.minhareceita.meal.data.api

import br.com.minhareceita.meal.domain.model.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealAPI {

    @GET("filter.php")
    suspend fun getMealsByCategoryName(
        @Query("c") mealCategoryName: String
    ) : MealsResponse
}