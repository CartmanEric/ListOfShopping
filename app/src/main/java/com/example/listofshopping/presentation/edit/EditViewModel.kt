package com.example.listofshopping.presentation.edit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.listofshopping.data.ListOfShoppingRepositoryImpl
import com.example.listofshopping.domain.DeleteListOfShoppingItemUseCase
import com.example.listofshopping.domain.EditListOfShoppingItemUseCase
import com.example.listofshopping.domain.ListOfShoppingModel
import kotlinx.coroutines.launch

class EditViewModel(application: Application): AndroidViewModel(application) {
    private val repository = ListOfShoppingRepositoryImpl(application)
    private val editItemUseCase = EditListOfShoppingItemUseCase(repository)
    private val deleteItemUseCase = DeleteListOfShoppingItemUseCase(repository)
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