package br.com.minhareceita.meal.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.minhareceita.core.NetworkCallback
import br.com.minhareceita.meal.domain.model.Meal
import br.com.minhareceita.meal.domain.model.MealsResponse
import br.com.minhareceita.meal.domain.usecase.MealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val useCase: MealsUseCase
) : ViewModel() {

    var category = ""
    val meals = MutableLiveData<List<Meal>>()
    val errorMessage = MutableLiveData<String>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getMealsByCategoryName(category, object : NetworkCallback<MealsResponse> {
                override fun onSuccess(response: MealsResponse) {
                    meals.postValue(response.meals)
                }

                override fun onError(t: Throwable) {
                    errorMessage.postValue(t.message)
                }
            })
        }
    }
}