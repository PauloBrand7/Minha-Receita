package br.com.minhareceita.recipe.domain.model


import com.google.gson.annotations.SerializedName

data class MealRecipeResponse(
    @SerializedName("meals")
    val meals: List<MealRecipeIngredients>
)