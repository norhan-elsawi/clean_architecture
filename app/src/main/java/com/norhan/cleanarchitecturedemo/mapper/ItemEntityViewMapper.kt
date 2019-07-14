package com.norhan.cleanarchitecturedemo.mapper

import com.norhan.cleanarchitecturedemo.entities.ItemView
import com.norhan.cleanarchitecturedemo.mapper.contract.Mapper
import com.norhan.domain.entities.ItemEntity
import javax.inject.Inject

class ItemEntityViewMapper @Inject constructor() : Mapper<ItemView, ItemEntity> {

    override fun mapToViewModel(entity: ItemEntity): ItemView {
        return ItemView(image = entity.image, itemName = entity.itemName, price = entity.price)
    }

    override fun mapToViewModel(list: List<ItemEntity>): List<ItemView> {
        return list.map { mapToViewModel(it) }
    }
}