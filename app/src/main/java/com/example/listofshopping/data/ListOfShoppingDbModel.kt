package com.example.listofshopping.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_of_shopping")
data class ListOfShoppingDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val lcd: String,
    val others: String,
    val ports: String
)