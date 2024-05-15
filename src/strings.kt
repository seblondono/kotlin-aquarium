fun main() {
    // String templates
    val num1 = 1
    val num2 = 2
    val stringTemplate = "Num $num1 and Num $num2"
    val sumString = "Num sum ${num1.plus(num2)}"
    
    // Booleans
    val fish = "fish"
    val plant = "plant"
    
    val areSame = fish == plant // false (by value comparison)
    val areSame2 = fish === plant // false (by reference comparison)
    
    // Comparisons
    val fishCount = 50
    if (fishCount in 1..100) println("good ratio")
    else
        println("bad ratio")
    
    when (fishCount) {
        0 -> println("no fish")
        50 -> println("good ratio")
        else -> println("bad ratio")
    }

    var welcomeMessage = "Hello and welcome to Kotlin"
    when (welcomeMessage.length) {
        0 -> println("Nothing to say?")
        in 1..50 -> println("Perfect")
        else -> println("Too long!")
    }
}