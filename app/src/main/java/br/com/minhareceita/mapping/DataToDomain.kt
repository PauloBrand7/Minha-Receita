package br.com.minhareceita.mapping

import br.com.minhareceita.data.model.FoodCategoriesResponse
import br.com.minhareceita.data.model.FoodCategoryResponse
import br.com.minhareceita.domain.model.FoodCategories
import br.com.minhareceita.domain.model.FoodCategory

fun FoodCategoriesResponse.map() =
    FoodCategories(
        foodCategory = foodCategoryResponse.map {
            map(it)
        }
    )

private fun map(foodCategoryResponse: FoodCategoryResponse) =
    FoodCategory(
        categoryId = foodCategoryResponse.categoryId,
        categoryName = foodCategoryResponse.categoryName,
        categoryDescription = foodCategoryResponse.categoryDescription,
        categoryImage = foodCategoryResponse.categoryImage
    )
