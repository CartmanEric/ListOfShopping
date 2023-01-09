package com.example.listofshopping.presentation.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listofshopping.domain.DeleteListOfShoppingItemUseCase
import com.example.listofshopping.domain.GetListOfShoppingItemsUseCase
import com.example.listofshopping.domain.ListOfShoppingModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class StartViewModel @Inject constructor(
    private val getListOfShoppingItemsUseCase: GetListOfShoppingItemsUseCase,
    private val deleteItemUseCase: DeleteListOfShoppingItemUseCase
) : ViewModel() {

    val listOfShopping = getListOfShoppingItemsUseCase.getItems()

    fun deleteItem(item: ListOfShoppingModel) {
        viewModelScope.launch {
            deleteItemUseCase.deleteItem(item)
        }
    }
}