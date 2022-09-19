package br.com.minhareceita.recipe.domain.model


import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @SerializedName("meals")
    val recipes: ArrayList<RecipeIngredients>
)