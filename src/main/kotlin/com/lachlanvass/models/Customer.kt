package com.lachlanvass.models

import kotlinx.serialization.Serializable

@Serializable
data class Customer(val id: String, val firstName: String, val lastName: String, val email: String)

val customerStorage = mutableListOf(
    Customer(
        id = "1",
        firstName = "Random",
        lastName = "Random2",
        email = "Random.Random@mail.com"
    )
)