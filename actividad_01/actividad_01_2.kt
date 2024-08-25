fun main(){
    jugarPiedraPapelTijera()
}
fun jugarPiedraPapelTijera() {
    // Lista de opciones disponibles
    val opciones = listOf("piedra", "papel", "tijera")

    // Elección aleatoria de la computadora
    val eleccionComputadora = opciones.random()

    // Pedir al usuario que elija
    println("Elige piedra, papel o tijera:")
    val eleccionUsuario = readLine()?.lowercase()

    // Verificar si la elección del usuario es válida
    if (eleccionUsuario in opciones) {
        // Mostrar elecciones
        println("La computadora eligió: $eleccionComputadora")
        println("Tú elegiste: $eleccionUsuario")

        // Determinar el resultado
        val resultado = determinarResultado(eleccionUsuario!!, eleccionComputadora)
        println(resultado)
    } else {
        println("Elección no válida. Por favor, elige piedra, papel o tijera.")
    }
}

fun determinarResultado(eleccionUsuario: String, eleccionComputadora: String): String {
    return if (eleccionUsuario == eleccionComputadora) {
        "Empate"
    } else if (
        (eleccionUsuario == "piedra" && eleccionComputadora == "tijera") ||
        (eleccionUsuario == "papel" && eleccionComputadora == "piedra") ||
        (eleccionUsuario == "tijera" && eleccionComputadora == "papel")
    ) {
        "¡Ganaste!"
    } else {
        "Perdiste"
    }
}