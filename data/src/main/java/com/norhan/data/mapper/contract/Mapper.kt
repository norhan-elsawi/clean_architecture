package com.norhan.data.mapper.contract

import com.norhan.data.entities.ItemData
import com.norhan.domain.entities.ItemEntity

interface Mapper<E, D> {
    fun mapFromEntity(entity: E): D
    fun mapToEntity(data: D): E
    fun mapToEntity(list: List<ItemData>): List<ItemEntity>
}