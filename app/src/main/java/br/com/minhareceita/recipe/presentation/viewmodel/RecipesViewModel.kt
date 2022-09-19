package br.com.minhareceita.recipe.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.minhareceita.recipe.domain.model.RecipeIngredients
import br.com.minhareceita.recipe.domain.usecase.RecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    private val useCase: RecipesUseCase
) {

    private var _listOfIngredients: ArrayList<RecipeIngredients> = arrayListOf()
    val listOfIngredients: MutableLiveData<ArrayList<RecipeIngredients>> = MutableLiveData()

    fun getRecipes(mealId : String) {
        viewModelScope.launch(Dispatchers.IO) {
            val ingredientsList = useCase.getRecipesById(mealId)
            _listOfIngredients = ingredientsList
            listOfIngredients.postValue(_listOfIngredients)
        }
    }
}