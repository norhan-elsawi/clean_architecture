package com.norhan.domain.repositories

import com.norhan.domain.entities.ItemDomain

interface HomeRepository {
    fun getItems(): ItemDomain
}