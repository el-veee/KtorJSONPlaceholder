package com.lachlanvass.plugins

import com.lachlanvass.models.customerStorage
import com.lachlanvass.routing.customerRouting
import io.ktor.server.plugins.autohead.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureRouting() {
    install(AutoHeadResponse)

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
    routing { }.customerRouting(customerStorage)


}