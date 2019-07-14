package com.norhan.data.repository.remote.impl

import com.norhan.data.repository.remote.api.ItemApi
import com.norhan.data.repository.remote.contract.HomeRemoteApis
import retrofit2.Retrofit
import javax.inject.Inject

class HomeRemoteApisImpl @Inject constructor(private val retrofit: Retrofit) : HomeRemoteApis {

    override fun getNewsApi(): ItemApi = retrofit.create(ItemApi::class.java)
}