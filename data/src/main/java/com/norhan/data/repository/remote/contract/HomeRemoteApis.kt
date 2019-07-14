package com.norhan.data.repository.remote.contract

import com.norhan.data.repository.remote.api.ItemApi

interface HomeRemoteApis {

    fun getNewsApi(): ItemApi
}