package com.example.listofshopping.presentation.add

import androidx.lifecycle.*
import com.example.listofshopping.domain.AddListOfShoppingItemUseCase
import com.example.listofshopping.domain.ListOfShoppingModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddViewModel @Inject constructor(
    private val addItemUseCase: AddListOfShoppingItemUseCase) : ViewModel() {

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    fun addItem(item: ListOfShoppingModel) {
        viewModelScope.launch {
            addItemUseCase.addItem(item)
            finish()
        }
    }

    private fun finish() {
        _shouldCloseScreen.value = Unit
    }
}
