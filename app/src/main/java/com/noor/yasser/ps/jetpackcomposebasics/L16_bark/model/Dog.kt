package com.noor.yasser.ps.jetpackcomposebasics.L16_bark.model

data class Dog(
    val id: Int,
    val name: String,
    val age: Double,
    val gender: String,
    val color: String,
    val weight: Double,
    val location: String,
    val image: Int,
    val about: String,
    val owner: Owner
)
