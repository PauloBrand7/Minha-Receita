package br.com.minhareceita.meal.domain.model

import com.google.gson.annotations.SerializedName

data class MealsResponse(
    @SerializedName("meals")
    val meals: ArrayList<Meal>
)