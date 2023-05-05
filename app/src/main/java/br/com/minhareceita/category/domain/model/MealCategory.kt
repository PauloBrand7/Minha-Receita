package br.com.minhareceita.category.domain.model


import com.google.gson.annotations.SerializedName

data class MealCategory(
    @SerializedName("idCategory")
    val id: String,
    @SerializedName("strCategory")
    val categoryName: String,
    @SerializedName("strCategoryDescription")
    val description: String,
    @SerializedName("strCategoryThumb")
    val image: String
)