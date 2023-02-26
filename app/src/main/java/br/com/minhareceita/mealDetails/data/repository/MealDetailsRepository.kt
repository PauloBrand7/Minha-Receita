package br.com.minhareceita.mealDetails.data.repository

import br.com.minhareceita.core.NetworkCallback
import br.com.minhareceita.meal.domain.model.MealsResponse
import br.com.minhareceita.mealDetails.data.api.MealDetailsAPI
import br.com.minhareceita.mealDetails.domain.repository.IMealDetailsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MealDetailsRepository @Inject constructor(
    private val mealDetailsApiService: MealDetailsAPI,
) : IMealDetailsRepository {

    override fun getMealDetail(
        recipeId: String,
        callback: NetworkCallback<MealsResponse>
    ) {
        mealDetailsApiService.getMealDetailsById(recipeId)
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