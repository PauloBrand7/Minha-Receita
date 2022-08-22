package br.com.minhareceita.domain.model.recipes


import com.google.gson.annotations.SerializedName

data class MealRecipeResponse(
    @SerializedName("meals")
    val meals: List<MealRecipeIngredients>
)