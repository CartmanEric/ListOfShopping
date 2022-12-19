package com.example.listofshopping.domain

data class ListOfShoppingModel (
    val lcd: String,
    val others: String,
    val ports: String,
    val id: Int = UNDEFINED_ID

        ): java.io.Serializable{
    companion object{
        const val UNDEFINED_ID = 0
    }
}