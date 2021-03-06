package objects

import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

class Server (port: Int = 9000) {
    private val httpServer: HttpServer = HttpServer.create(InetSocketAddress(port), 0)

    fun start() {
        httpServer.executor = null
        httpServer.start()
        println("Server started")
    }

    fun addEndpoint(endpoint: String, callback: HttpHandler) {
        httpServer.createContext(endpoint, callback)
        println("Endpoint $endpoint added")
    }
}