package com.example.listofshopping.di

import android.app.Application
import com.example.listofshopping.data.AppDatabase
import com.example.listofshopping.data.ListOfShoppingDao
import dagger.Module
import dagger.Provides

@Module
class DataModule {

        @Provides
        fun provideListOfShoppingDao(application: Application): ListOfShoppingDao{
            return AppDatabase.getInstance(application).listOfShoppingDao()
        }

}