package com.lachlanvass.routing

import com.lachlanvass.plugins.configureRouting
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class CustomerRouteKtTest {

    @Test
    fun testCustomersRouteStatusOk() = testApplication {
        application {
            configureRouting()
        }
        client.get("/customer").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun testMissingIdReturnsBadRequest() = testApplication {
        application {
            configureRouting()
        }

        client.get("/customer/").apply {

            assertEquals(HttpStatusCode.BadRequest, status)
        }
    }

    @Test
    fun testIdNotFound() = testApplication {
        application {
            configureRouting()
        }

        client.get("/customer/999").apply {

            assertEquals(HttpStatusCode.NotFound, status)
        }
    }

}