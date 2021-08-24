package maker_memory.routes

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*

fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        post("/user") {
            val req =  call.receiveParameters()
            println(req)
        }
    }
    routing {
        customerById()
    }
}
