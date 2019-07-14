package com.norhan.cleanarchitecturedemo.mapper.contract

interface Mapper<out V, in E> {
    fun mapToViewModel(entity: E): V
    fun mapToViewModel(list: List<E>): List<V>
}