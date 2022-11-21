package br.com.minhareceita.meal.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.minhareceita.meal.domain.model.Meal
import br.com.minhareceita.meal.domain.usecase.MealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val useCase: MealsUseCase
) : ViewModel() {

    var category = ""
    val meals = MutableLiveData<List<Meal>>()
    private var _meals = listOf<Meal>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(500)
            _meals = useCase.getMealsByCategoryName(category)
            meals.postValue(_meals)
        }
    }
}