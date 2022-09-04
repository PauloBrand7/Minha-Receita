package br.com.minhareceita.category.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.minhareceita.category.domain.model.MealCategory
import br.com.minhareceita.category.domain.usecase.MealCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealCategoryViewModel @Inject constructor(
    private val useCase: MealCategoryUseCase
) : ViewModel() {

    private lateinit var _listOfCategories: List<MealCategory>
    val listOfCategories: MutableLiveData<List<MealCategory>> = MutableLiveData()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val categoriesList = useCase.getCategories()
            _listOfCategories = categoriesList.categories
            listOfCategories.postValue(_listOfCategories)
        }
    }

}