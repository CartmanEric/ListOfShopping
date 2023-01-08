package com.example.listofshopping.presentation.edit

import androidx.lifecycle.*
import com.example.listofshopping.domain.DeleteListOfShoppingItemUseCase
import com.example.listofshopping.domain.EditListOfShoppingItemUseCase
import com.example.listofshopping.domain.ListOfShoppingModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class EditViewModel @Inject constructor(
    private val deleteItemUseCase: DeleteListOfShoppingItemUseCase,
    private val editItemUseCase: EditListOfShoppingItemUseCase
): ViewModel() {
    private val _checkConditionScreen = MutableLiveData<Unit>()
    val checkConditionScreen: LiveData<Unit>
        get() = _checkConditionScreen



    fun editItem(item: ListOfShoppingModel){
        viewModelScope.launch {
            editItemUseCase.editItem(item)
            finish()
        }
    }
    fun deleteItem(item: ListOfShoppingModel){
        viewModelScope.launch {
            deleteItemUseCase.deleteItem(item)
            finish()
        }
    }
    private fun finish() {
        _checkConditionScreen.value = Unit
    }

}