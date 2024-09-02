// Descripción: Sistema de gestión de biblioteca para manejar materiales y usuarios.
// Autor:Enyelbert
// Fecha de creación: 01/09/2024
// Fecha de última modificación: 01/09/2024

abstract class Material(val titulo: String, val autor: String, val anioPublicacion: Int) {
    abstract fun mostrarDetalles()
}

class Libro(titulo: String, autor: String, anioPublicacion: Int, val genero: String, val numeroPaginas: Int) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numeroPaginas")
    }
}

class Revista(titulo: String, autor: String, anioPublicacion: Int, val issn: String, val volumen: Int, val numero: Int, val editorial: String) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Revista: $titulo, Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial")
    }
}

data class Usuario(val nombre: String, val apellido: String, val edad: Int)

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestamo(usuario: Usuario, material: Material)
    fun devolucion(usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)
}

class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuarios = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
        println("Material registrado: ${material.titulo}")
    }

    override fun registrarUsuario(usuario: Usuario) {
        usuarios.putIfAbsent(usuario, mutableListOf())
        println("Usuario registrado: ${usuario.nombre} ${usuario.apellido}")
    }

    override fun prestamo(usuario: Usuario, material: Material) {
        if (material in materialesDisponibles) {
            materialesDisponibles.remove(material)
            usuarios[usuario]?.add(material)
            println("Préstamo realizado: ${material.titulo} a ${usuario.nombre}")
        } else {
            println("El material no está disponible para préstamo.")
        }
    }

    override fun devolucion(usuario: Usuario, material: Material) {
        if (material in usuarios[usuario] ?: emptyList()) {
            usuarios[usuario]?.remove(material)
            materialesDisponibles.add(material)
            println("Devolución realizada: ${material.titulo} por ${usuario.nombre}")
        } else {
            println("El material no pertenece a este usuario.")
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("Materiales reservados por ${usuario.nombre}:")
        usuarios[usuario]?.forEach { it.mostrarDetalles() }
    }
}

// Ejemplo de uso
fun main() {
    val biblioteca = Biblioteca()

    val libro1 = Libro("1984", "George Orwell", 1949, "Distopía", 328)
    val revista1 = Revista("National Geographic", "Varios Autores", 2023, "0027-9358", 45, 6, "National Geographic Society")

    val usuario1 = Usuario("Juan", "Pérez", 25)

    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(revista1)
    biblioteca.registrarUsuario(usuario1)

    biblioteca.prestamo(usuario1, libro1)
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)

    biblioteca.devolucion(usuario1, libro1)
    biblioteca.mostrarMaterialesDisponibles()
}
