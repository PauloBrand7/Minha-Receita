package br.com.minhareceita.mealDetails.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.minhareceita.meal.domain.model.Meal
import br.com.minhareceita.mealDetails.domain.usecase.MealDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(
    private val useCase: MealDetailsUseCase
): ViewModel() {

    private var _ingredients: ArrayList<Meal> = arrayListOf()
    val ingredients: MutableLiveData<ArrayList<Meal>> = MutableLiveData()

    fun getRecipes(mealId : String) {
        viewModelScope.launch(Dispatchers.IO) {
            _ingredients = useCase.getRecipesById(mealId)
            ingredients.postValue(_ingredients)
        }
    }
}