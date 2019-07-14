package com.norhan.cleanarchitecturedemo.di.modules.data

import com.norhan.data.executor.JobExecutor
import com.norhan.data.repository.impl.HomeRepositoryImpl
import com.norhan.domain.executor.ThreadExecutor
import com.norhan.domain.repositories.HomeRepository
import dagger.Binds
import dagger.Module

@Module(includes = [ApiModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor

    @Binds
    abstract fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository
}