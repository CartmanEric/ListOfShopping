package com.example.listofshopping.domain

class EditListOfShoppingItemUseCase(private val listOfShoppingRepository: ListOfShoppingRepository) {
    suspend fun editItem(item: ListOfShoppingModel){
        listOfShoppingRepository.editItem(item)
    }
}