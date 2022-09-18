package br.com.minhareceita.meal.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.minhareceita.meal.domain.model.Meal
import br.com.minhareceita.meal.domain.usecase.MealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.properties.ObservableProperty

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val useCase: MealsUseCase
) : ViewModel() {

    private var _listOfMeals: ArrayList<Meal> = arrayListOf()
    val listOfMeals: MutableLiveData<ArrayList<Meal>> = MutableLiveData()

//    init {
//        getMeals()
//    }

    fun getMeals(mealsName : String) {
        viewModelScope.launch(Dispatchers.IO) {
            val categoriesList = useCase.getMealsByCategoryName(mealsName)
            _listOfMeals = categoriesList
            listOfMeals.postValue(_listOfMeals)
        }
    }
}