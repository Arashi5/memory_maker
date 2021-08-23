package maker.memory

import com.typesafe.config.ConfigFactory
import maker.memory.plugins.*
import maker.memory.server_grpc.GrpcServer
import io.ktor.server.netty.*
import io.ktor.server.engine.*

fun main(args: Array<String>) {
    GrpcServer(args, ConfigFactory.load().getInt("ktor.deployment.grpcPort")).start()
    embeddedServer(Netty, ConfigFactory.load().getInt("ktor.deployment.port")) {
        configureRouting()
    }.start(wait = true)
}