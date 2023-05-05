package br.com.minhareceita.category.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.minhareceita.category.domain.model.MealCategoriesResponse
import br.com.minhareceita.category.domain.model.MealCategory
import br.com.minhareceita.category.domain.usecase.MealCategoryUseCase
import br.com.minhareceita.core.NetworkCallback
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealCategoryViewModel @Inject constructor(
    private val useCase: MealCategoryUseCase
) : ViewModel() {

    val listOfCategories = MutableLiveData<List<MealCategory>>()
    val errorMessage = MutableLiveData<String>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getCategories(object : NetworkCallback<MealCategoriesResponse> {

                override fun onSuccess(response: MealCategoriesResponse) {
                    listOfCategories.postValue(response.categories)
                }

                override fun onError(t: Throwable) {
                    errorMessage.postValue(t.message)
                }
            })
        }
    }

}