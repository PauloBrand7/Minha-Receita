package br.com.minhareceita.meal.data.repository

import br.com.minhareceita.core.NetworkCallback
import br.com.minhareceita.meal.data.api.MealAPI
import br.com.minhareceita.meal.domain.model.MealsResponse
import br.com.minhareceita.meal.domain.repository.IMealRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MealRepository @Inject constructor(
    private val mealApiService: MealAPI
) : IMealRepository {

    override fun getMeals(
        mealCategoryName: String,
        callback: NetworkCallback<MealsResponse>
    ) {
        mealApiService.getMealsByCategoryName(mealCategoryName)
            .enqueue(object : Callback<MealsResponse> {

                override fun onResponse(
                    call: Call<MealsResponse>,
                    response: Response<MealsResponse>
                ) {
                    takeIf { response.isSuccessful }?.apply {
                        response.body()?.let {
                            callback.onSuccess(it)
                        }
                    }
                }

                override fun onFailure(call: Call<MealsResponse>, t: Throwable) {
                    callback.onError(t)
                }
            })
    }
}