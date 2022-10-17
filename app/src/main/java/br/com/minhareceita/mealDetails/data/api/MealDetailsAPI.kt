package br.com.minhareceita.mealDetails.data.api

import br.com.minhareceita.meal.domain.model.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealDetailsAPI {

    @GET("lookup.php")
    suspend fun getRecipeById(
        @Query("i") id: String
    ): MealsResponse

}