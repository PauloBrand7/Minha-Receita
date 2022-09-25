package br.com.minhareceita.recipe.data.repository

import br.com.minhareceita.recipe.data.api.RecipeAPI
import br.com.minhareceita.meal.domain.model.MealsResponse
import br.com.minhareceita.recipe.domain.repository.IRecipeRepository
import javax.inject.Inject


class RecipeRepository @Inject constructor(
    private val recipeApiService: RecipeAPI,
) : IRecipeRepository {

    override suspend fun getRecipes(recipeId: String): MealsResponse {
        return recipeApiService.getRecipeById(recipeId)
    }

}