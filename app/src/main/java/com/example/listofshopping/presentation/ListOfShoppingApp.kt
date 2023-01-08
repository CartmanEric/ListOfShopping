package com.example.listofshopping.presentation

import android.app.Application
import com.example.listofshopping.di.DaggerApplicationComponent

class ListOfShoppingApp:Application() {

   val component by lazy {
      DaggerApplicationComponent.factory().create(this) }
}