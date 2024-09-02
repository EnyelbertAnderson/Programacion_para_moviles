// Autor:Enyelbert
// Fecha de creación: 01/09/2024
// Fecha de última modificación: 01/09/2024

class Producto(private var precio: Double, private var descuento: Double) {

    // Método get para obtener el precio
    fun getPrecio(): Double {
        return precio
    }

    // Método set para establecer el precio con validación
    fun setPrecio(nuevoPrecio: Double) {
        if (nuevoPrecio >= 0) {
            precio = nuevoPrecio
        } else {
            println("El precio no puede ser negativo.")
        }
    }

    // Método get para obtener el descuento
    fun getDescuento(): Double {
        return descuento
    }

    // Método set para establecer el descuento con validación
    fun setDescuento(nuevoDescuento: Double) {
        if (nuevoDescuento in 0.0..100.0) {
            descuento = nuevoDescuento
        } else {
            println("El descuento debe estar entre 0 y 100.")
        }
    }

    // Método para calcular el precio final después de aplicar el descuento
    fun calcularPrecioFinal(): Double {
        return precio - (precio * descuento / 100)
    }
}

// Ejemplo de uso
fun main() {
    val producto = Producto(200.0, 10.0)
    println("Precio final después del descuento: ${producto.calcularPrecioFinal()}")
    producto.setDescuento(15.0)
    println("Precio final después del nuevo descuento: ${producto.calcularPrecioFinal()}")
}