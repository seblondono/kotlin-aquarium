package Aquarium

// Singleton
object MobyDickWhale {
    val author = "H. G. Wells"
    fun jump() {
        // jump
    }
}

// Exactly one of each member, you can add methods to enums
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
} 

// Sealed classes
// can be subclasses but only in the same file
sealed class Seal

class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal) {
    return when(seal) {
        is Walrus -> println("walrus")
        is SeaLion -> println("sea lion")
    }
}