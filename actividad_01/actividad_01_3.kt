fun main() {
    while (true) {
        // Mostrar el menú de opciones
        mostrarMenu()

        // Leer la opción seleccionada por el usuario
        val opcion = readLine()?.toIntOrNull()

        // Validar la opción ingresada
        if (opcion != null && opcion in 1..5) {
            when (opcion) {
                1 -> realizarOperacion("suma", ::sumar)
                2 -> realizarOperacion("resta", ::restar)
                3 -> realizarOperacion("multiplicación", ::multiplicar)
                4 -> realizarOperacion("división", ::dividir)
                5 -> {
                    println("Saliendo...")
                    break
                }
            }
        } else {
            println("Opción no válida. Por favor, elige una opción del 1 al 5.")
        }
    }
}

// Función para mostrar el menú
fun mostrarMenu() {
    println("==== Menú ====")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicación")
    println("4. División")
    println("5. Salir")
    print("Selecciona una opción: ")
}

// Función para realizar la operación seleccionada
fun realizarOperacion(nombreOperacion: String, operacion: (Double, Double) -> Double) {
    println("Has elegido $nombreOperacion.")

    // Leer los números ingresados por el usuario
    print("Ingresa el primer número: ")
    val num1 = readLine()?.toDoubleOrNull()

    print("Ingresa el segundo número: ")
    val num2 = readLine()?.toDoubleOrNull()

    // Validar la entrada de números
    if (num1 != null && num2 != null) {
        val resultado = operacion(num1, num2)
        println("El resultado de la $nombreOperacion es: $resultado")
    } else {
        println("Entrada no válida. Por favor, ingresa números válidos.")
    }
}

// Funciones para cada operación matemática
fun sumar(a: Double, b: Double): Double = a + b

fun restar(a: Double, b: Double): Double = a - b

fun multiplicar(a: Double, b: Double): Double = a * b

fun dividir(a: Double, b: Double): Double {
    return if (b != 0.0) {
        a / b
    } else {
        println("Error: No se puede dividir entre cero.")
        Double.NaN
    }
}

