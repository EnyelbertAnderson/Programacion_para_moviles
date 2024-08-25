fun main() {
    var puntuacion: Double

    // Solicita la puntuación y valida que esté en el rango permitido
    do {
        println("Ingrese su puntuación (0 a 10):")
        puntuacion = readLine()?.toDoubleOrNull() ?: -1.0
        if (puntuacion < 0 || puntuacion > 10) {
            println("Puntuación solo permitida de 0 a 10. Intente nuevamente.")
        }
    } while (puntuacion < 0 || puntuacion > 10)

    println("Ingrese su salario mensual:")
    val salario = readLine()?.toDoubleOrNull() ?: 0.0

    val (nivelRendimiento, dineroRecibido) = calcularPuntuacion(puntuacion, salario)
    println("Nivel de Rendimiento: $nivelRendimiento")
    println("Cantidad de Dinero Recibido: $${"%.2f".format(dineroRecibido)}")
}

fun calcularPuntuacion(puntuacion: Double, salario: Double): Pair<String, Double> {
    val nivelRendimiento = when {
        puntuacion <= 3.0 -> "Inaceptable"
        puntuacion <= 6.0 -> "Aceptable"
        else -> "Meritorio"
    }
    val dineroRecibido = salario * (puntuacion / 10)
    return nivelRendimiento to dineroRecibido
}

