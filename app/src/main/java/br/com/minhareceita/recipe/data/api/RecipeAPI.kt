package br.com.minhareceita.recipe.data.api

import br.com.minhareceita.recipe.domain.model.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeAPI {

    @GET("lookup.php")
    suspend fun getRecipeById(
        @Query("i") id: String
    ): RecipeResponse

}