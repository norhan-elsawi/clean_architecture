package com.norhan.cleanarchitecturedemo.ui.main

import androidx.lifecycle.MutableLiveData
import com.norhan.cleanarchitecturedemo.base.BaseViewModel
import com.norhan.cleanarchitecturedemo.base.Data
import com.norhan.cleanarchitecturedemo.entities.ItemView
import com.norhan.cleanarchitecturedemo.mapper.ItemEntityViewMapper
import com.norhan.domain.entities.ItemEntity
import com.norhan.domain.usecases.GetItemUseCases
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mapper: ItemEntityViewMapper,
    private val getItemUseCases: GetItemUseCases
) :
    BaseViewModel<List<ItemEntity>, List<ItemView>>() {

    val items = MutableLiveData<Data<List<ItemView>>>()

    fun initItemList() {
        subscribe(getItemUseCases.getNews(), items)
    }

    override fun getMappedResponse(data: List<ItemEntity>): List<ItemView> {
        return mapper.mapToViewModel(data)
    }
}