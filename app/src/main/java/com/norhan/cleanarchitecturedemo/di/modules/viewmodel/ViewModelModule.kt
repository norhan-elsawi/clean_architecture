package com.norhan.cleanarchitecturedemo.di.modules.viewmodel


import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

//    @Binds
//    @IntoMap
//    @ViewModelKey(BrowseBufferoosViewModel::class)
//    abstract fun bindBrowseBufferoosViewModel(viewModel: BrowseBufferoosViewModel): ViewModel

}