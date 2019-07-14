package com.norhan.cleanarchitecturedemo.di.modules

import com.norhan.cleanarchitecturedemo.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Module that provides all dependencies from the mobile-ui package/layer and injects all activities.
 */
@Module
abstract class UiModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}