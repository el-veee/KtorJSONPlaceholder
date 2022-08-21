package com.lachlanvass.routing

import com.lachlanvass.models.Customer
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.withTimeout

fun Route.customerRouting(customerStorage: List<Customer>) {
    route("/customer") {
        get {

            withTimeout(100L) {

                if (customerStorage.isNotEmpty()) {
                    call.respond(customerStorage)
                } else {
                    call.respondText("No customers found:", status = HttpStatusCode.OK )
                }
            }
        }
        get("{id?}") {

            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing ID",
                status = HttpStatusCode.BadRequest
            )

            val customer = customerStorage.find {
                it.id == id
            } ?: return@get call.respondText(
                "No Customer with id: $id",
                status = HttpStatusCode.NotFound
            )

            call.respond(customer)

        }
        post {

        }
        delete {

        }
    }
}