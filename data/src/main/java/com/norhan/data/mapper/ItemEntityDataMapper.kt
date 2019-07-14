package com.norhan.data.mapper

import com.norhan.data.entities.ItemData
import com.norhan.data.mapper.contract.Mapper
import com.norhan.domain.entities.ItemEntity
import javax.inject.Inject

class ItemEntityDataMapper @Inject constructor() : Mapper<ItemEntity, ItemData> {

    override fun mapFromEntity(entity: ItemEntity): ItemData {
        return ItemData(entity.image, entity.itemName, entity.price, entity.description, entity.sort, entity.category)
    }

    override fun mapToEntity(data: ItemData): ItemEntity {
        return ItemEntity(data.image, data.itemName, data.price, data.description, data.sort, data.category)
    }

    override fun mapToEntity(list: List<ItemData>): List<ItemEntity> {
        return list.map { mapToEntity(it) }
    }
}