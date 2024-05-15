import java.util.Arrays

fun main() {
    // How to mutate a list
    val myList = mutableListOf("tuna", "salmon", "shark")
    //myList = mutableListOf("koi", "goldfish") // error
    
    val myList2 = mutableListOf("tuna", "salmon", "shark")
    myList2.remove("shark")
    
    // Arrays
    var fish = 12
    var plants = 5
    val swarm = listOf(fish, plants)
    
    val school = arrayOf("tuna", "salmon", "shark")
    val numbers = intArrayOf(1, 2, 3)
    
    // cannot add elements of different type to a typed array
    //println(Arrays.toString(intArrayOf(2, "foo")))
    
    // but you can mix types on untyped arrays
    val mix = arrayOf("fish", 2)
    println(Arrays.toString(mix))
    
    // array of arrays
    val bigSwarm = arrayOf(swarm, school)
    
    // initializing arrays
    val array = Array(5){it*2} // [0, 2, 4, 6, 8] (it = index in this case)
    
    // Loops
    for (element in swarm) println(element)
    
    for ((index, value) in school.withIndex()) println("element at $index is $value")
    
    // Ranges
    for (i in 'b'..'g') println(i) // b, c, d, e, f, g
    
    for (i in 1..5) println(i) // 1, 2, 3, 4, 5
    
    for (i in 5 downTo 1) println(i) // 5, 4, 3, 2, 1
    
    for (i in 1 until 5) println(i) // 1, 2, 3, 4

    for (i in 3..6 step 2) println(i) // 3, 5
}