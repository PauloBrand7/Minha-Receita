package br.com.minhareceita.meal.presentation.listener

import br.com.minhareceita.meal.domain.model.Meal

interface MealClickListener {
    fun mealOnClick(category : Meal)
}