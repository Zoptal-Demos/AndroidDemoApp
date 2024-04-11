package com.zoptal.munzul.di.module


import androidx.lifecycle.ViewModelProvider
import com.zoptal.tappapp.di.viewmodelprovider.ViewModelFactory
import dagger.Binds
import dagger.Module




@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

//   @Binds
//    @IntoMap
//    @ViewModelKey(LoginRegisterViewModel::class)
//    protected abstract fun loginRegisterViewModel(loginRegisterViewModel: LoginRegisterViewModel): ViewModel



}