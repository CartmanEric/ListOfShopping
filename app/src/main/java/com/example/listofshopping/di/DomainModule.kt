package com.example.listofshopping.di

import com.example.listofshopping.data.ListOfShoppingRepositoryImpl
import com.example.listofshopping.domain.ListOfShoppingRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {
@Binds
fun bindListOfShoppingRepository(impl: ListOfShoppingRepositoryImpl):ListOfShoppingRepository
}