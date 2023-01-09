package com.example.listofshopping.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.listofshopping.domain.ListOfShoppingModel
import com.example.listofshopping.domain.ListOfShoppingRepository
import javax.inject.Inject

class ListOfShoppingRepositoryImpl @Inject constructor(
    private val mapper: ListOfShoppingMapper,
    private val listOfShoppingDao: ListOfShoppingDao
) : ListOfShoppingRepository {

    override fun getItems(): LiveData<List<ListOfShoppingModel>> {
        return Transformations.map(listOfShoppingDao.getItems()) {
            mapper.mapListDbModelToListEntity(it)
        }
    }

    override suspend fun addItem(item: ListOfShoppingModel) {
        listOfShoppingDao.addItem(mapper.mapEntityToDbModel(item))
    }

    override suspend fun deleteItem(item: ListOfShoppingModel) {
        listOfShoppingDao.deleteShopItem(item.id)
    }

    override suspend fun editItem(item: ListOfShoppingModel) {
        listOfShoppingDao.addItem(mapper.mapEntityToDbModel(item))
    }
}