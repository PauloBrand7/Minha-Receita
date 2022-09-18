package br.com.minhareceita.category.domain.model


import com.google.gson.annotations.SerializedName

data class MealCategoriesResponse(
    @SerializedName("categories")
    val categories: ArrayList<MealCategory>
)