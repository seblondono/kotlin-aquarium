package Aquarium.Decorations

fun main(args: Array<String>) {
    makeDecorations()
}

fun makeDecorations() {
    val decoration1 = Decorations("granite")
    println(decoration1)
    val decoration2 = Decorations("slate")
    println(decoration2)
    val decoration3 = Decorations("slate")
    println(decoration3)
    
    println(decoration1.equals(decoration2)) // false
    println(decoration2.equals(decoration3)) // true
    
    val decorations4 = decoration3.copy() // new object with same property values
    
    val decorations5 = Decorations2("crystal", "wood", "diver")
    
    // object decomposition, no need for parenthesis, same order has they are declared, same number of variables
    val (rock, wood, diver) = decorations5
    println(rock)
    println(wood)
    println(diver)
}

// with a data class, printing the object, prints the values of properties,
// instead of just an address of the object, iot creates a "toString()" for us to print the properties
data class Decorations(val rocks: String) {}

data class Decorations2(val rocks: String, val wood: String, val diver: String) {}