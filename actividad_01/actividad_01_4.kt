import kotlin.random.Random

fun main() {
    // Generar un número aleatorio entre 1 y 30
    val numeroAleatorio = Random.nextInt(1, 31)
    var intentosRestantes = 5

    println("Adivina el número entre 1 y 30. Tienes $intentosRestantes intentos.")

    while (intentosRestantes > 0) {
        print("Ingresa tu número: ")
        val intentoUsuario = readLine()?.toIntOrNull()

        if (intentoUsuario != null) {
            if (intentoUsuario == numeroAleatorio) {
                println("¡Felicidades! Adivinaste el número correctamente.")
                return // Termina el programa si adivina correctamente
            } else if (intentoUsuario < numeroAleatorio) {
                println("El número a adivinar es mayor.")
            } else {
                println("El número a adivinar es menor.")
            }

            // Disminuir el número de intentos restantes
            intentosRestantes--
            println("Te quedan $intentosRestantes intentos.")

        } else {
            println("Entrada no válida. Por favor, ingresa un número entre 1 y 30.")
        }

        // Si el usuario se queda sin intentos
        if (intentosRestantes == 0) {
            println("Game Over. El número correcto era $numeroAleatorio.")
        }
    }
}

