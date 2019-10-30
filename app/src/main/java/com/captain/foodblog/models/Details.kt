package com.captain.foodblog.models

data class Details(
    val about: List<String>,
    val dishes: List<String>,
    val images: List<String>,
    val `where`: List<Where>
)