package maker.memory

import io.ktor.application.*
import kotlinx.coroutines.*
import maker.memory.plugins.*
import maker.memory.server_grpc.Server

fun main(args: Array<String>) {
    server(args)
}

fun server(args: Array<String>) = runBlocking {
    grpc()
    http(args)
}

suspend fun grpc() = coroutineScope {
    val port = 50052
    val server = Server(port)
    val grpc = async {
        server.start()
        server.blockUntilShutdown()
    }
    grpc.join()
}

suspend fun http(args: Array<String>) = coroutineScope {
    val http = async {
        io.ktor.server.netty.EngineMain.main(args)
    }
    http.join()
}


fun Application.module() {
    configureRouting()
}
