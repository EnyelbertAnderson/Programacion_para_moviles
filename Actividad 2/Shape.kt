// Descripción: Sistema de clases para calcular el área y perímetro de figuras geométricas.

// Autor:Enyelbert
// Fecha de creación: 01/09/2024
// Fecha de última modificación: 01/09/2024

abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Área: ${calcularArea()}")
        println("Perímetro: ${calcularPerimetro()}")
    }
}

class Cuadrado(private val lado: Double) : Shape() {
    override fun calcularArea(): Double {
        return lado * lado
    }

    override fun calcularPerimetro(): Double {
        return 4 * lado
    }
}

class Circulo(private val radio: Double) : Shape() {
    override fun calcularArea(): Double {
        return Math.PI * radio * radio
    }

    override fun calcularPerimetro(): Double {
        return 2 * Math.PI * radio
    }
}

class Rectangulo(private val largo: Double, private val ancho: Double) : Shape() {
    override fun calcularArea(): Double {
        return largo * ancho
    }

    override fun calcularPerimetro(): Double {
        return 2 * (largo + ancho)
    }
}

// Ejemplo de uso
fun main() {
    val cuadrado = Cuadrado(5.0)
    cuadrado.imprimirResultados()

    val circulo = Circulo(3.0)
    circulo.imprimirResultados()

    val rectangulo = Rectangulo(4.0, 6.0)
    rectangulo.imprimirResultados()
}
