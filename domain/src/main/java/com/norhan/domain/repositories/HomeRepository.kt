package com.norhan.domain.repositories

import com.norhan.domain.entities.ItemEntity
import io.reactivex.Single

interface HomeRepository {
    fun getItems(): Single<List<ItemEntity>>
}