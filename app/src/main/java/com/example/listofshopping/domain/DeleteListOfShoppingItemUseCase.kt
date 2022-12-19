package com.example.listofshopping.domain

class DeleteListOfShoppingItemUseCase(private val listOfShoppingRepository: ListOfShoppingRepository){
    suspend fun deleteItem(item: ListOfShoppingModel){
        listOfShoppingRepository.deleteItem(item)
    }
}