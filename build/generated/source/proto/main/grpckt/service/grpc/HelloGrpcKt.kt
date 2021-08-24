package service.grpc

import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls.serverStreamingRpc
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls.serverStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow
import service.grpc.ServiceGrpc.getServiceDescriptor

/**
 * Holder for Kotlin coroutine-based client and server APIs for service.grpc.Service.
 */
object HelloGrpcKt {
  const val SERVICE_NAME: String = ServiceGrpc.SERVICE_NAME

  @JvmStatic
  val serviceDescriptor: ServiceDescriptor
    get() = ServiceGrpc.getServiceDescriptor()

  val sayHelloMethod: MethodDescriptor<HelloRequest, HelloReply>
    @JvmStatic
    get() = ServiceGrpc.getSayHelloMethod()

  val sayHellosMethod: MethodDescriptor<HelloRequest, HelloReply>
    @JvmStatic
    get() = ServiceGrpc.getSayHellosMethod()

  /**
   * A stub for issuing RPCs to a(n) service.grpc.Service service as suspending coroutines.
   */
  @StubFor(ServiceGrpc::class)
  class ServiceCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT
  ) : AbstractCoroutineStub<ServiceCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): ServiceCoroutineStub =
        ServiceCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @return The single response from the server.
     */
    suspend fun sayHello(request: HelloRequest): HelloReply = unaryRpc(
      channel,
      ServiceGrpc.getSayHelloMethod(),
      request,
      callOptions,
      Metadata()
    )
    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    fun sayHellos(request: HelloRequest): Flow<HelloReply> = serverStreamingRpc(
      channel,
      ServiceGrpc.getSayHellosMethod(),
      request,
      callOptions,
      Metadata()
    )}

  /**
   * Skeletal implementation of the service.grpc.Service service based on Kotlin coroutines.
   */
  abstract class ServiceCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for service.grpc.Service.SayHello.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun sayHello(request: HelloRequest): HelloReply = throw
        StatusException(UNIMPLEMENTED.withDescription("Method service.grpc.Service.SayHello is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for service.grpc.Service.SayHellos.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open fun sayHellos(request: HelloRequest): Flow<HelloReply> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method service.grpc.Service.SayHellos is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ServiceGrpc.getSayHelloMethod(),
      implementation = ::sayHello
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = ServiceGrpc.getSayHellosMethod(),
      implementation = ::sayHellos
    )).build()
  }
}
