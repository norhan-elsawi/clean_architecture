package com.norhan.cleanarchitecturedemo.di.modules

import com.norhan.data.repository.remote.contract.HomeRemoteApis
import com.norhan.data.repository.remote.impl.HomeRemoteApisImpl
import dagger.Binds
import dagger.Module

@Module
abstract class ApisModule {

    @Binds
    abstract fun bindHomeRemoteApis(homeRemoteApisImpl: HomeRemoteApisImpl): HomeRemoteApis
}