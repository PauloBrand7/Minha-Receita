package br.com.minhareceita.core

import android.view.View
import androidx.navigation.findNavController
import br.com.minhareceita.R
import br.com.minhareceita.meal.domain.model.Meal

fun Meal.details(): List<String> {
    val mealDetails = (1..20).mapNotNull { index ->
        val measure = this.javaClass.getDeclaredField("measure$index").get(this) as String?
        val ingredient = this.javaClass.getDeclaredField("ingredient$index").get(this) as String?
        measure.concatMeasure(ingredient)
    }
    return mealDetails
}

fun String?.concatMeasure(ingredient: String?): String? {
    takeIf { (!this.isNullOrEmpty() && !ingredient.isNullOrEmpty()) }?.let {
        return "$ingredient.$this"
    }
    return null
}

fun View.navToNetworkErrorFragment() {
    findNavController().navigate(R.id.nav_network_error)
}