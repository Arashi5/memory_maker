package maker.memory

import io.ktor.application.*
import maker.memory.plugins.*
import maker.memory.server_grpc.GreeterServer

fun main(args: Array<String>): Unit {
    io.ktor.server.netty.EngineMain.main(args)

    val port = 50052
    val server = GreeterServer(port)
    server.start()
    server.blockUntilShutdown()
}


fun Application.module() {
    configureRouting()
}
