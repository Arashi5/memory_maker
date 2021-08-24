package maker_memory

import com.typesafe.config.ConfigFactory
import maker_memory.routes.*
import maker_memory.server_grpc.GrpcServer
import io.ktor.server.netty.*
import io.ktor.server.engine.*
import mu.KotlinLogging

fun  main(args: Array<String>) {
    val logger = KotlinLogging.logger {}
    GrpcServer(args, ConfigFactory.load().getInt("ktor.deployment.grpcPort"), logger).start()
    embeddedServer(Netty, ConfigFactory.load().getInt("ktor.deployment.port")) {
        configureRouting()
    }.start(wait = true)
}