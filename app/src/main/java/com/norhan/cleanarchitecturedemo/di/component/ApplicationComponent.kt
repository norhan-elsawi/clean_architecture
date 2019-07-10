package com.norhan.cleanarchitecturedemo.di.component

import android.app.Application
import com.norhan.cleanarchitecturedemo.application.ProjectApplication
import com.norhan.cleanarchitecturedemo.di.modules.ApplicationModule
import com.norhan.cleanarchitecturedemo.di.modules.NetworkModule
import com.norhan.cleanarchitecturedemo.di.modules.ThreadModule
import com.norhan.cleanarchitecturedemo.di.modules.UiModule
import com.norhan.cleanarchitecturedemo.di.modules.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        ApplicationModule::class,
        NetworkModule::class,
        UiModule::class,
        ThreadModule::class,
        ViewModelModule::class]
)
interface ApplicationComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: ProjectApplication)
}