package com.norhan.data.entities

import com.google.gson.annotations.SerializedName

data class ItemData(

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("itemName")
    val itemName: String? = null,

    @field:SerializedName("price")
    val price: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("sort")
    val sort: String? = null,

    @field:SerializedName("category")
    val category: String? = null
)