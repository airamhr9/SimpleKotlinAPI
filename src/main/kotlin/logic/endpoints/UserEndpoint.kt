package logic.endpoints

import com.sun.net.httpserver.HttpExchange
import logic.EndpointHandler
import logic.RequestParser
import objects.persistence.Usuario


class UserEndpoint(endpoint: String) : EndpointHandler<Usuario>(endpoint) {

    override fun handleExchange(exchange: HttpExchange) {
        println("handling exchange")
        lateinit var response : String
         when(exchange.requestMethod){
                "GET" -> {
                    response = "GET request"
                    //TODO("Not yet implemented")
                    val parameters : Map<String, Any?> = RequestParser.getQueryParameters(exchange.requestURI)
                    val argumentList = parameters.keys
                }
                "POST" -> {
                    response = "POST request"
                    //TODO("Not yet implemented")
                    //val objectToPost: JsonObject = exchange.requestBody
                }
                "PUT" -> {
                    response = "PUT request"
                    //TODO("Not yet implemented")
                }
                "OPTIONS" -> {
                    /**
                     * Endpoint que devuelve un objeto que define los
                     * métodos de petición
                     * Por ejemplo:
                     * Para este endpoint devolvería "GET" "POST" Y "PUT", con los parámetros necesarios de cada uno
                     */
                    response = "OPTIONS request"
                }
                else -> {
                    //405 Método no soportado
                    exchange.sendResponseHeaders(405, -1)
                    response = "Method not supported"
                }
            }
        exchange.sendResponseHeaders(200, response.toByteArray(Charsets.UTF_8).size.toLong())
        val outputStream = exchange.responseBody
        outputStream.write(response.toByteArray())
        outputStream.flush()
        exchange.close()
    }

    override fun getIndividualById(objectId: Int): Usuario {
        TODO("Not yet implemented")
    }

    override fun getDefaultList(): List<Usuario> {
        TODO("Not yet implemented")
    }

    override fun getListByIds(idList: List<Int>): List<Usuario> {
        TODO("Not yet implemented")
    }

    override fun postIndividual(newObject: Usuario): Usuario {
        TODO("Not yet implemented")
    }

    override fun put(modifiedObject: Usuario): Usuario {
        TODO("Not yet implemented")
    }

    override fun responseToJson(): String {
        TODO("Not yet implemented")
    }
}