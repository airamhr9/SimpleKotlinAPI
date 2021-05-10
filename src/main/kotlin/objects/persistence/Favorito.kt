package objects.persistence

import com.google.gson.JsonObject
import objects.JsonConvertible

class Favorito(
    var usuario: Usuario,
    var inmueble: InmuebleSprint2,
    var notas: String,
    var orden: Int
) : JsonConvertible {

    override fun toJson(): JsonObject {
        val result = JsonObject()
        result.add("usuario", usuario.toJson())
        result.add("inmueble", inmueble.toJson())
        result.addProperty("notas", notas)
        result.addProperty("orden", orden)
        return result
    }

    companion object {

        fun fromJson(jsonObject: JsonObject): Favorito {
            val usuario = Usuario.fromJson(jsonObject.getAsJsonObject("usuario"))

            val inmuebleJsonObject = jsonObject.getAsJsonObject("inmueble")
            val modeloInmueble = ModeloInmueble.fromString(inmuebleJsonObject.get("modelo").asString)
            val inmueble = when (modeloInmueble) {
                ModeloInmueble.Piso -> Piso.fromJson(inmuebleJsonObject)
                ModeloInmueble.Local -> Local.fromJson(inmuebleJsonObject)
                ModeloInmueble.Garaje -> Garaje.fromJson(inmuebleJsonObject)
                ModeloInmueble.Habitacion -> Habitacion.fromJson(inmuebleJsonObject)
            }

            val notas = jsonObject.get("notas").asString
            val orden = jsonObject.get("orden").asInt

            return Favorito(usuario, inmueble, notas, orden)
        }

    }
}