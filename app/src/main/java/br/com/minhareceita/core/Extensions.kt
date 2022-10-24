package br.com.minhareceita.core

import br.com.minhareceita.meal.domain.model.Meal
import java.lang.StringBuilder

fun Meal.details(): ArrayList<String?> {
    return arrayListOf(
        measure1.concatMeasure(ingredient1),
        measure2.concatMeasure(ingredient2),
        measure3.concatMeasure(ingredient3),
        measure4.concatMeasure(ingredient4),
        measure5.concatMeasure(ingredient5),
        measure6.concatMeasure(ingredient6),
        measure7.concatMeasure(ingredient7),
        measure8.concatMeasure(ingredient8),
        measure9.concatMeasure(ingredient9),
        measure10.concatMeasure(ingredient10),
        measure11.concatMeasure(ingredient11),
        measure12.concatMeasure(ingredient12),
        measure13.concatMeasure(ingredient13),
        measure14.concatMeasure(ingredient14),
        measure15.concatMeasure(ingredient15),
        measure16.concatMeasure(ingredient16),
        measure17.concatMeasure(ingredient17),
        measure18.concatMeasure(ingredient18),
        measure19.concatMeasure(ingredient19),
        measure20.concatMeasure(ingredient20)
    )
}

fun String?.concatMeasure(ingredient: String?): String? {
    takeIf { (!this.isNullOrEmpty() && !ingredient.isNullOrEmpty()) }?.let {
        return "- $this $ingredient"
    }
    return null
}
