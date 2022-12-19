package com.example.listofshopping.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.listofshopping.domain.ListOfShoppingModel
import com.example.listofshopping.domain.ListOfShoppingRepository

class ListOfShoppingRepositoryImpl(application: Application) : ListOfShoppingRepository {
    private val listOfShoppingDao = AppDatabase.getInstance(application).listOfShoppingDao()
    private val mapper = ListOfShoppingMapper()
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