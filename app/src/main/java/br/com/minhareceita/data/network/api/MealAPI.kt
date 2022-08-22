package br.com.minhareceita.data.network.api

import br.com.minhareceita.domain.model.areas.AreasResponse
import br.com.minhareceita.domain.model.categories.MealsCategoryResponse
import br.com.minhareceita.domain.model.meals.MealsResponse
import br.com.minhareceita.domain.model.recipes.MealRecipeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealAPI {

    @GET("categories.php")
    suspend fun getCategories(): MealsCategoryResponse

    @GET("list.php?a=list")
    suspend fun getAreasList(): AreasResponse

    @GET("filter.php")
    suspend fun getMealsByCategoryName(
        @Query("c") mealCategoryName: String
    ) : MealsResponse

    @GET("filter.php")
    suspend fun getMealsByArea(
        @Query("a") mealArea: String
    ) : AreasResponse

    @GET("lookup.php")
    suspend fun getRecipeMealById(
        @Query("i") id: String
    ): MealRecipeResponse

}