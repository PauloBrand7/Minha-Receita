package br.com.minhareceita.category.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.minhareceita.category.domain.model.MealCategory
import br.com.minhareceita.category.domain.usecase.MealCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealCategoryViewModel @Inject constructor(
    private val useCase: MealCategoryUseCase
) : ViewModel() {

    private var _listOfCategories = listOf<MealCategory>()
    val listOfCategories = MutableLiveData<List<MealCategory>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _listOfCategories = useCase.getCategories()
            listOfCategories.postValue(_listOfCategories)
        }
    }

}