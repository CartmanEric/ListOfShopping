package com.example.listofshopping.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class GetListOfShoppingItemsUseCase @Inject constructor(
    private val listOfShoppingRepository: ListOfShoppingRepository) {
    fun getItems(): LiveData<List<ListOfShoppingModel>> {
        return listOfShoppingRepository.getItems()
    }
}