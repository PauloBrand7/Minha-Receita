package br.com.minhareceita.mapping

import br.com.minhareceita.domain.model.FoodCategories
import br.com.minhareceita.domain.model.FoodCategory
import br.com.minhareceita.presentation.model.FoodCategoriesUI
import br.com.minhareceita.presentation.model.FoodCategoryUI

fun FoodCategories.map() =
    FoodCategoriesUI(
        foodCategory = foodCategory.map {
            map(it)
        }
    )

private fun map(foodCategory: FoodCategory) =
    FoodCategoryUI(
        categoryId = foodCategory.categoryId,
        categoryName = foodCategory.categoryName,
        categoryDescription = foodCategory.categoryDescription,
        categoryImage = foodCategory.categoryImage
    )