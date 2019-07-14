package com.norhan.data.repository.impl

import com.norhan.data.mapper.ItemEntityDataMapper
import com.norhan.data.repository.remote.contract.HomeRemoteApis
import com.norhan.domain.entities.ItemEntity
import com.norhan.domain.repositories.HomeRepository
import io.reactivex.Single
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeRemoteApiCalls: HomeRemoteApis,
    private val mapper: ItemEntityDataMapper
) : HomeRepository {

    override fun getItems(): Single<List<ItemEntity>> {
        return homeRemoteApiCalls.getNewsApi().getNews().map { mapper.mapToEntity(it) }
    }
}