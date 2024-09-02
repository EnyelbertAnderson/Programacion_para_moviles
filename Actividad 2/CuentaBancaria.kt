//Clase para gestionar una cuenta bancaria con saldo y límite de retiro.
// Autor:Enyelbert
// Fecha de creación: 01/09/2024
// Fecha de última modificación: 01/09/2024

class CuentaBancaria(private var saldo: Double, private var limiteRetiro: Double) {

    // Método get para obtener el saldo
    fun getSaldo(): Double {
        return saldo
    }

    // Método set para establecer el saldo con validación
    fun setSaldo(nuevoSaldo: Double) {
        if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo
        } else {
            println("El saldo no puede ser negativo.")
        }
    }

    // Método get para obtener el límite de retiro
    fun getLimiteRetiro(): Double {
        return limiteRetiro
    }

    // Método set para establecer el límite de retiro con validación
    fun setLimiteRetiro(nuevoLimite: Double) {
        if (nuevoLimite >= 0) {
            limiteRetiro = nuevoLimite
        } else {
            println("El límite de retiro no puede ser negativo.")
        }
    }

    // Método para realizar un retiro
    fun retirar(monto: Double) {
        if (monto <= limiteRetiro && monto <= saldo) {
            saldo -= monto
            println("Retiro exitoso de $$monto. Saldo restante: $$saldo.")
        } else {
            println("Retiro fallido. Verifique el saldo y el límite de retiro.")
        }
    }
}

// Ejemplo de uso
fun main() {
    val cuenta = CuentaBancaria(1000.0, 300.0)
    cuenta.retirar(250.0)
    cuenta.setSaldo(1500.0)
    cuenta.retirar(350.0)
}
