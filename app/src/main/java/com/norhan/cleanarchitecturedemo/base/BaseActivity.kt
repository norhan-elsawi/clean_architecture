package com.norhan.cleanarchitecturedemo.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.norhan.cleanarchitecturedemo.di.modules.viewmodel.ViewModelFactory
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    fun <T : ViewModel> getViewModel(classType: Class<T>): T {
        return ViewModelProviders.of(this, viewModelFactory).get(classType)
    }

}