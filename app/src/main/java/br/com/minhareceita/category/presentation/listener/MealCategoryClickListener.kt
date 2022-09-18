package br.com.minhareceita.category.presentation.listener

import br.com.minhareceita.category.domain.model.MealCategory

interface MealCategoryClickListener {
    fun categoryOnClick(category : MealCategory)
}