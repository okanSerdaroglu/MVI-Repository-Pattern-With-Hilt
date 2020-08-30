package com.okan.mvi_repository_pattern_with_hilt.model


// this is project level Blog Model
data class Blog(
    var id: Int,
    var title: String,
    var body: String,
    var image: String,
    var category: String
)