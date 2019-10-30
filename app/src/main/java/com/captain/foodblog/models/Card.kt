package com.captain.foodblog.models

data class Card(
    val card_no: Int,
    val desc: String,
    val details: Details,
    val img: String,
    val title: String
)