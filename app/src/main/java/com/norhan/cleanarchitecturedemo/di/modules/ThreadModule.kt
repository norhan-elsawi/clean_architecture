package com.norhan.cleanarchitecturedemo.di.modules

import com.norhan.cleanarchitecturedemo.utils.UiThread
import com.norhan.data.executor.JobExecutor
import com.norhan.domain.executor.PostExecutionThread
import com.norhan.domain.executor.ThreadExecutor
import dagger.Binds
import dagger.Module

@Module
abstract class ThreadModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @Binds
    abstract fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor
}