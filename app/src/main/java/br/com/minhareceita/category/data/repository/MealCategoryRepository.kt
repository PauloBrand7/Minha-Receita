package br.com.minhareceita.category.data.repository

import br.com.minhareceita.category.data.api.MealCategoryAPI
import br.com.minhareceita.category.domain.model.MealCategoriesResponse
import br.com.minhareceita.category.domain.repository.IMealCategoryRepository
import br.com.minhareceita.core.NetworkCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MealCategoryRepository @Inject constructor(
    private val mealCategoryApiService: MealCategoryAPI
) : IMealCategoryRepository {

    override fun getCategories(callback: NetworkCallback<MealCategoriesResponse>) {
        mealCategoryApiService.getCategories().enqueue(object : Callback<MealCategoriesResponse> {

            override fun onResponse(
                call: Call<MealCategoriesResponse>,
                response: Response<MealCategoriesResponse>
            ) {
                takeIf { response.isSuccessful }?.apply {
                    response.body()?.let {
                        callback.onSuccess(it)
                    }
                }
            }

            override fun onFailure(call: Call<MealCategoriesResponse>, t: Throwable) {
                callback.onError(t)
            }
        })
    }

}