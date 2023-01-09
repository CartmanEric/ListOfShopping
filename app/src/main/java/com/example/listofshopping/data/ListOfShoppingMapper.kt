package com.example.listofshopping.data

import com.example.listofshopping.domain.ListOfShoppingModel
import javax.inject.Inject

class ListOfShoppingMapper @Inject constructor() {
    fun mapEntityToDbModel(listOfShoppingModel: ListOfShoppingModel) = ListOfShoppingDbModel(
        id = listOfShoppingModel.id,
        lcd = listOfShoppingModel.lcd,
        others = listOfShoppingModel.others,
        ports = listOfShoppingModel.ports
    )

    private fun mapDbModelToEntity(listOfShoppingDbModel: ListOfShoppingDbModel) = ListOfShoppingModel(
        id = listOfShoppingDbModel.id,
        lcd = listOfShoppingDbModel.lcd,
        others = listOfShoppingDbModel.others,
        ports = listOfShoppingDbModel.ports
    )

    fun mapListDbModelToListEntity(list: List<ListOfShoppingDbModel>) = list.map {
        mapDbModelToEntity(it)
    }

}