package logic.endpoints

import com.google.gson.Gson
import com.sun.net.httpserver.HttpExchange
import logic.EndpointHandler
import logic.RequestParser
import objects.persistence.User


class UserEndpoint(endpoint: String) : EndpointHandler<User>(endpoint) {

    override fun handleExchange(exchange: HttpExchange) {
         when(exchange.requestMethod){
                "GET" -> {
                    TODO("Not yet implemented")
                }
                "POST" -> {
                    TODO("Not yet implemented")
                }
                "PUT" -> {
                    TODO("Not yet implemented")
                }
                "OPTIONS" -> {
                    /**
                     * Endpoint que devuelve un objeto que define los
                     * métodos de petición
                     * Por ejemplo:
                     * Para este endpoint devolvería "GET" "POST" Y "PUT", con los parámetros necesarios de cada uno
                     */
                }
                else -> {
                    //405 Método no soportado
                    exchange.sendResponseHeaders(405, -1)
                }
            }
        exchange.close()
    }

    override fun getIndividualById(objectId: Int): User {
        TODO("Not yet implemented")
    }

    override fun getDefaultList(): List<User> {
        TODO("Not yet implemented")
    }

    override fun getListByIds(idList: List<Int>): List<User> {
        TODO("Not yet implemented")
    }

    override fun postIndividual(newObject: User): User {
        TODO("Not yet implemented")
    }

    override fun put(modifiedObject: User): User {
        TODO("Not yet implemented")
    }

    override fun responseToJson(): String {
        TODO("Not yet implemented")
    }
}