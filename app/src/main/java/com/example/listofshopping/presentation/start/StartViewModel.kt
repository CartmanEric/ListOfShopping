package com.example.listofshopping.presentation.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.listofshopping.data.ListOfShoppingRepositoryImpl
import com.example.listofshopping.domain.DeleteListOfShoppingItemUseCase
import com.example.listofshopping.domain.GetListOfShoppingItemsUseCase
import com.example.listofshopping.domain.ListOfShoppingModel
import kotlinx.coroutines.launch

class StartViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = ListOfShoppingRepositoryImpl(application)
    private val getListOfShoppingItemsUseCase = GetListOfShoppingItemsUseCase(repository)
    private val deleteItemUseCase = DeleteListOfShoppingItemUseCase(repository)


    val listOfShopping = getListOfShoppingItemsUseCase.getItems()

    fun deleteItem(item: ListOfShoppingModel) {
        viewModelScope.launch {
            deleteItemUseCase.deleteItem(item)

        }
    }
}