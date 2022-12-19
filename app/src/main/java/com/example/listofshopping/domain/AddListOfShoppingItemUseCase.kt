package com.example.listofshopping.domain

class AddListOfShoppingItemUseCase(private val listOfShoppingRepository: ListOfShoppingRepository) {
   suspend fun addItem(item: ListOfShoppingModel){
       listOfShoppingRepository.addItem(item)
    }
}