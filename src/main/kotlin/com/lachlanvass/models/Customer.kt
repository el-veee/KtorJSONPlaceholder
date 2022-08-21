package com.lachlanvass.models

import kotlinx.serialization.Serializable

@Serializable
data class Customer(val id: String, val firstName: String, val lastName: String, val email: String)

val customerStorage = (1..900000).map { it -> generateCustomer(it) }

fun generateCustomer(id: Int): Customer {
    return Customer(
        id = id.toString(),
        firstName = "Random",
        lastName = "Random2",
        email = "Random.Random@mail.com"
    )
}