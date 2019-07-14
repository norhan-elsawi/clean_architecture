package com.norhan.cleanarchitecturedemo.di.modules

import com.norhan.cleanarchitecturedemo.ui.main.MainActivity
import com.norhan.cleanarchitecturedemo.utils.UiThread
import com.norhan.domain.executor.PostExecutionThread
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Module that provides all dependencies from the mobile-ui package/layer and injects all activities.
 */
@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity


}