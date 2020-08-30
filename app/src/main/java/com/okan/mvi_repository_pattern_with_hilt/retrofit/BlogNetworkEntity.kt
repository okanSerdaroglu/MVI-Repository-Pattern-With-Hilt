package com.okan.mvi_repository_pattern_with_hilt.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

// this is the same with API looks like
data class BlogNetworkEntity(

    @SerializedName("pk")
    @Expose
    val id: Int,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("body")
    @Expose
    val body: String,

    @SerializedName("category")
    @Expose
    val category: String,

    @SerializedName("image")
    @Expose
    val image: String

)
