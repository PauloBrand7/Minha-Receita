package br.com.minhareceita.recipe.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
): ViewModel() {

    private var _ingredients: ArrayList<RecipeIngredients> = arrayListOf()
    val ingredients: MutableLiveData<ArrayList<RecipeIngredients>> = MutableLiveData()

    fun getRecipes(mealId : String) {
        viewModelScope.launch(Dispatchers.IO) {
            _ingredients = useCase.getRecipesById(mealId)
            ingredients.postValue(_ingredients)
        }
    }
}