package com.example.listofshopping.di

import androidx.lifecycle.ViewModel
import com.example.listofshopping.presentation.add.AddViewModel
import com.example.listofshopping.presentation.edit.EditViewModel
import com.example.listofshopping.presentation.start.StartViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(StartViewModel::class)
    @Binds
    fun bindStartViewModel(impl: StartViewModel): ViewModel

    @IntoMap
    @ViewModelKey(AddViewModel::class)
    @Binds
    fun bindAddViewModel(impl: AddViewModel): ViewModel

    @IntoMap
    @ViewModelKey(EditViewModel::class)
    @Binds
    fun bindEditViewModel(impl: EditViewModel): ViewModel
}