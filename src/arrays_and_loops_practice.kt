import java.util.Arrays

fun main() {
    val numbers = intArrayOf(11,12,13,14,15)
    val list = mutableListOf<String>()
    
    for (number in numbers) {
        list.add(number.toString())
    }
    
    // list of numbers between 0 and 100 that are divisible by 7
    val divisibleBy7 = mutableListOf<Int>()
    for (number in 7..100 step 7) {
        divisibleBy7.add(number)
    }
    println(divisibleBy7)
}