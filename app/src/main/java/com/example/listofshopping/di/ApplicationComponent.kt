package com.example.listofshopping.di

import android.app.Application
import com.example.listofshopping.presentation.add.AddFragment
import com.example.listofshopping.presentation.edit.EditFragment
import com.example.listofshopping.presentation.start.StartFragment
import dagger.BindsInstance
import dagger.Component



@ApplicationScope
@Component(modules = [DomainModule::class, DataModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun injectAddFragment(addFragment: AddFragment)
    fun injectEditFragment(editFragment: EditFragment)
    fun injectStartFragment(startFragment: StartFragment)

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance application: Application
        ):ApplicationComponent

    }

}