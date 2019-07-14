package com.norhan.cleanarchitecturedemo.di.modules.data

import com.norhan.data.repository.remote.contract.HomeRemoteApis
import com.norhan.data.repository.remote.impl.HomeRemoteApisImpl
import dagger.Binds
import dagger.Module

@Module
abstract class ApiModule {

    @Binds
    abstract fun bindHomeRemoteApis(homeRemoteApisImpl: HomeRemoteApisImpl): HomeRemoteApis
}