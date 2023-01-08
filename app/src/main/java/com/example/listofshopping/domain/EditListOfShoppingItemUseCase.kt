package com.example.listofshopping.domain

import javax.inject.Inject

class EditListOfShoppingItemUseCase @Inject constructor(
    private val listOfShoppingRepository: ListOfShoppingRepository) {
    suspend fun editItem(item: ListOfShoppingModel){
        listOfShoppingRepository.editItem(item)
    }
}