package br.com.minhareceita.mealDetails.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.minhareceita.core.NetworkCallback
import br.com.minhareceita.meal.domain.model.Meal
import br.com.minhareceita.meal.domain.model.MealsResponse
import br.com.minhareceita.mealDetails.domain.usecase.MealDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(
    private val useCase: MealDetailsUseCase
): ViewModel() {

    var mealId = ""
    val mealDetails = MutableLiveData<Meal>()
    val errorMessage = MutableLiveData<String>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getMealById(mealId, object : NetworkCallback<MealsResponse> {
                override fun onSuccess(response: MealsResponse) {
                    mealDetails.postValue(response.meals[0])
                }

                override fun onError(t: Throwable) {
                    errorMessage.postValue(t.message)
                }
            })

        }
    }
}