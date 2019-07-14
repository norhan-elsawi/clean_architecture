package com.norhan.cleanarchitecturedemo.di.component

import android.app.Application
import com.norhan.cleanarchitecturedemo.application.ProjectApplication
import com.norhan.cleanarchitecturedemo.di.modules.*
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
        DataModule::class,
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