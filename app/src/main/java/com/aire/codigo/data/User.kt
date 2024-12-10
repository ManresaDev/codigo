package com.aire.codigo.data

import androidx.annotation.DrawableRes

data class User(
    val name : String,
    val surName : String,
    @DrawableRes val image : Int
)
