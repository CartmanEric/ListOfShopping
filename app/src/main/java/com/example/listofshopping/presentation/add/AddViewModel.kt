package com.example.listofshopping.presentation.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.listofshopping.data.ListOfShoppingRepositoryImpl
import com.example.listofshopping.domain.AddListOfShoppingItemUseCase
import com.example.listofshopping.domain.ListOfShoppingModel
import kotlinx.coroutines.launch

class AddViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = ListOfShoppingRepositoryImpl(application)
    private val addItemUseCase = AddListOfShoppingItemUseCase(repository)
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
