package maker.memory

import com.typesafe.config.ConfigFactory
import io.ktor.application.*
import io.ktor.config.*
import io.ktor.http.*
import kotlinx.coroutines.*
import maker.memory.plugins.*
import maker.memory.server_grpc.Server

fun main(args: Array<String>) {
    server(args)
}

fun server(args: Array<String>) = runBlocking {
    async {
        Server(ConfigFactory.load().getInt("ktor.deployment.grpcPort")).start()
        io.ktor.server.netty.EngineMain.main(args)
    }
}

fun Application.module() {
    val port = environment.config.propertyOrNull("ktor.deployment.grpcPort")?.getString() ?: "8080"
    configureRouting()
}
