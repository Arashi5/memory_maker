package maker_memory

import com.typesafe.config.ConfigFactory
import maker_memory.plugins.*
import maker_memory.server_grpc.GrpcServer
import io.ktor.server.netty.*
import io.ktor.server.engine.*
import io.ktor.application.*

fun  main(args: Array<String>) {
    GrpcServer(args, ConfigFactory.load().getInt("ktor.deployment.grpcPort")).start()
    embeddedServer(Netty, ConfigFactory.load().getInt("ktor.deployment.port")) {
        configureRouting()
    }.start(wait = true)
}