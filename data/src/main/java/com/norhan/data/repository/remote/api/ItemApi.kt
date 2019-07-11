package com.norhan.data.repository.remote.api

import com.norhan.data.entities.ItemData
import io.reactivex.Single
import retrofit2.http.GET

interface ItemApi {
    @GET("/services/json/itemsfeed.php")
    fun getNews(): Single<ItemData>
}