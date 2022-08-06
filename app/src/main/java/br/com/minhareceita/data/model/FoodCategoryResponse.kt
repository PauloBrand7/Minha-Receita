package br.com.minhareceita.data.model

import com.google.gson.annotations.SerializedName

data class FoodCategoryResponse(
    @SerializedName("idCategory")
    val categoryId: String,
    @SerializedName("strCategory")
    val categoryName: String,
    @SerializedName("strCategoryDescription")
    val categoryDescription: String,
    @SerializedName("strCategoryThumb")
    val categoryImage: String
)