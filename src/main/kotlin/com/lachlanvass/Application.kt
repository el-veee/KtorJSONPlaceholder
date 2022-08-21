
package com.lachlanvass

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.lachlanvass.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureTemplating()
        configureSerialization()
        configureRouting()
    }.start(wait = true)

}
