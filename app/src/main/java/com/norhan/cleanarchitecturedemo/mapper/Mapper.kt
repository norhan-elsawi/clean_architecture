package com.norhan.cleanarchitecturedemo.mapper

interface Mapper<out V, in D> {
    fun mapToViewModel(type: D): V
}