fun main(args: Array<String>) {
    // adding helpful behaviour to classes you do not own
    // they do not actually modify the classes that they are extending
    // use them to separate the API from helper methods on classes you do own
}

fun String.hasSpaces(): Boolean {
    val found = this.find { it == ' ' }
    return found != null
}

fun String.kotlinizedHasSpaces() = find { it == ' '} != null

fun extensionsExample() {
    println("Hello World".hasSpaces()) // true
}

// Helper method on classes
open class AquariumPlant(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

fun AquariumPlant.isRed() = color == "red" // extension function has no access to private vals

fun AquariumPlant.print() = println("This is an AquariumPlant")
fun GreenLeafyPlant.print() = println("This is a GreenLeafyPlant")

fun staticExample() {
    val greenPlan = GreenLeafyPlant(size =  50)
    greenPlan.print() // This is a GreenLeafyPlant
    
    val plant: AquariumPlant = greenPlan
    plant.print() // This is an AquariumPlant ???!!!
    // the extension function is resolved statically, that is at compile time, and the compiler
    // only looks at the type of the variable, which in this case it AquariumPlant
}

// Extension properties

val AquariumPlant.isGreen: Boolean
    get() = color == "green"

fun propertyExample() {
    val plant = AquariumPlant("green", 50)
    println("Is the plant green? ${plant.isGreen}")
}

// you can also make the class you are extending (the receiver) nullable
// add this when you expect callers to call methods on nullable receivers
// or provide default behaviour when your method is applied to "null"
fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
        // remove()
    }
}

fun nullableExample() {
    val plant: AquariumPlant? = null
    plant.pull()
}