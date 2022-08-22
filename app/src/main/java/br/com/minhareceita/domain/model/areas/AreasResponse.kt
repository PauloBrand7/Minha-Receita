package br.com.minhareceita.domain.model.areas

import com.google.gson.annotations.SerializedName

data class AreasResponse(
    @SerializedName("strArea")
    val meals: List<String>
)