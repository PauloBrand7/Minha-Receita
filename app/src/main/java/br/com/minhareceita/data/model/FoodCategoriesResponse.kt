package br.com.minhareceita.data.model

import com.google.gson.annotations.SerializedName

data class FoodCategoriesResponse(
    @SerializedName("categories")
    val foodCategoryResponse: List<FoodCategoryResponse>
)