package br.com.minhareceita.domain.model.categories


import br.com.minhareceita.domain.model.categories.MealCategory
import com.google.gson.annotations.SerializedName

data class MealsCategoryResponse(
    @SerializedName("categories")
    val categories: List<MealCategory>
)