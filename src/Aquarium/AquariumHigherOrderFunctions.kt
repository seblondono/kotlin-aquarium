package Aquarium

data class FishHOF(var name: String)

class AquariumHigherOrderFunctions {
}

fun main(args: Array<String>) {
    fishExampleHOF()

    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    val prime = divisibleBy3(numbers) { this.rem(3) }
    println(prime)
}

fun fishExampleHOF() {
    val fish = FishHOF("splashy")
    println(fish.name)

    // without inline the object is created on every call to myWith
    myWith(fish.name) {
        println(capitalize())
    }

    println(fish.run { name })
    println(fish.apply {})

    val fish2 = FishHOF(name = "splashy").apply { name = "Sharky" }
    println(fish2.name)

    println(
        fish.name.capitalize()
            .let { it + "fish" }.length
            .let { it + 123 }
    )
}

// adding inline to the function declaration makes sure the lambda is not created everytime 
// (less overhead >performance)
inline fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun divisibleBy3(list: List<Int>, block: Int.() -> Int): List<Int> {
    val output = mutableListOf<Int>()
    list.forEach { if (it.block() == 0) {
        output.add(it)
    }
    }
    return output
}

// SAM = Single Abstract Method = An interface with 1 method on it
interface Runnable {
    fun run()
}

interface Callable<T> {
    fun call(): T
}

// In Kotlin
fun example() {
    val runnable: Runnable = object : Runnable {
        override fun run() {
            println("Hello")
        }
    }
}