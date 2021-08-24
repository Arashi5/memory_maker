package maker_memory.server_grpc

import io.grpc.ManagedChannel
import kotlinx.coroutines.flow.Flow
import service.grpc.ServiceGrpcKt.ServiceCoroutineStub
import service.grpc.HelloReply
import service.grpc.HelloRequest

/**
 * Greeter Coroutines Service
 *
 * @author linux_china
 */
interface Service {
    suspend fun sayHello(request: HelloRequest): HelloReply
    fun sayHellos(request: HelloRequest): Flow<HelloReply>
}

/**
 * Greeter Service Stub to call remote gRPC service
 * @param channel managed channel
 */
class ServiceStub constructor(
    channel: ManagedChannel
) : Service {
    private val stub: ServiceCoroutineStub = ServiceCoroutineStub(channel)

    override suspend fun sayHello(request: HelloRequest): HelloReply {
        return stub.sayHello(request)
    }

    override fun sayHellos(request: HelloRequest): Flow<HelloReply> {
        return stub.sayHellos(request)
    }
}