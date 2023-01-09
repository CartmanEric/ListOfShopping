package com.example.listofshopping.domain

import javax.inject.Inject

class AddListOfShoppingItemUseCase @Inject constructor(
    private val listOfShoppingRepository: ListOfShoppingRepository
) {
    suspend fun addItem(item: ListOfShoppingModel) {
        listOfShoppingRepository.addItem(item)
    }
}