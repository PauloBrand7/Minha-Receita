package br.com.minhareceita.mealDetails.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.minhareceita.meal.domain.model.Meal
import br.com.minhareceita.mealDetails.domain.usecase.MealDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(
    private val useCase: MealDetailsUseCase
): ViewModel() {

    var mealId = ""
    val mealDetails = MutableLiveData<Meal>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(500)
            mealDetails.postValue(useCase.getMealById(mealId))
        }
    }
}