package maker.memory.server_grpc

import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.protobuf.services.ProtoReflectionService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import service.grpc.ServiceGrpcKt
import service.grpc.HelloReply
import service.grpc.HelloRequest
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId

class GrpcServer constructor(
    private val args: Array<String>,
    private val port: Int
) {
    private val server: Server = ServerBuilder
        .forPort(port)
        .addService(ServiceImpl())
        .addService(ProtoReflectionService.newInstance())
        .build()

    fun start() {
        server.start()
        var dt = Instant.now().atZone(ZoneId.systemDefault()).toLocalDateTime()
        println(java.lang.String.format("$dt [grpc] INFO server started, listening on $port"))
        Runtime.getRuntime().addShutdownHook(
            Thread {
                dt = Instant.now().atZone(ZoneId.systemDefault()).toLocalDateTime()
                println("$dt [grpc] shutting down gRPC server since JVM is shutting down")
                this@GrpcServer.stop()
                dt = Instant.now().atZone(ZoneId.systemDefault()).toLocalDateTime()
                println("$dt [grpc] server shut down")
            }
        )
    }

    private fun stop() {
        server.shutdown()
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }

    private class ServiceImpl : ServiceGrpcKt.ServiceCoroutineImplBase(), Service {
        override suspend fun sayHello(request: HelloRequest): HelloReply {
            return HelloReply.newBuilder().setMessage("Hello ${request.name}").build()
        }

        override fun sayHellos(request: HelloRequest): Flow<HelloReply> {
            return arrayOf("Hello", "你好").map {
                HelloReply.newBuilder().setMessage("$it ${request.name}").build()
            }.asFlow()
        }
    }
}
