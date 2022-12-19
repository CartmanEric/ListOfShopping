package com.example.listofshopping.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ListOfShoppingDao {

    @Query("SELECT * FROM list_of_shopping")
    fun getItems(): LiveData<List<ListOfShoppingDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItem(item: ListOfShoppingDbModel)

    @Query("DELETE FROM list_of_shopping WHERE id=:itemId")
    suspend fun deleteShopItem(itemId: Int)




}