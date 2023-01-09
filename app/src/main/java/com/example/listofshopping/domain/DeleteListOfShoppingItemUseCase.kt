package com.example.listofshopping.domain

import javax.inject.Inject

class DeleteListOfShoppingItemUseCase @Inject constructor(
    private val listOfShoppingRepository: ListOfShoppingRepository
) {
    suspend fun deleteItem(item: ListOfShoppingModel) {
        listOfShoppingRepository.deleteItem(item)
    }
}