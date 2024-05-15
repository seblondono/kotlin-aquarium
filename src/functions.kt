import java.util.*

// Every function in Kotlin returns something, even if there is no return statement
// main returns a type Unit (no value)
fun main(args: Array<String>) {
    println("Hi Kotlin")

    dayOfWeek()

    // args[0] comes from run configuration argument value
    println("Hello, ${args[0]}!")

    // everything has a value, even if that value is Unit
    val isUnit = println("this is an expression")
    println(isUnit)

    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)

    // String templates
    val message = "You are ${if (temperature > 50) "fried" else "safe"} fish"
    println(message)

    // Lambdas
    var dirty = 20
    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    waterFilter(10)
    fun feedFish(dirty: Int) = dirty + 10

    // Higher order functions (take other functions as arguments)
    // function arguments should be the last parameters
    fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
        return operation(dirty)
    }

    fun dirtyProcessor() {
        dirty = updateDirty(dirty, waterFilter)
        dirty = updateDirty(dirty, ::feedFish)
        dirty = updateDirty(dirty) { dirty -> dirty + 50 }
    }

}

fun dayOfWeek() {
    println("What day is today?")
//    when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
//        Calendar.MONDAY -> println("Monday")
//        Calendar.TUESDAY -> println("Tuesday")
//        Calendar.WEDNESDAY -> println("Wednesday")
//        Calendar.THURSDAY -> println("Thursday")
//        Calendar.FRIDAY -> println("Friday")
//        Calendar.SATURDAY -> println("Saturday")
//        Calendar.SUNDAY -> println("Sunday")
//    }

    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println(
        when (day) {
            1 -> "Sunday"
            2 -> "Monday"
            3 -> "Tuesday"
            4 -> "Wednesday"
            5 -> "Thursday"
            6 -> "Friday"
            7 -> "Saturday"
            else -> "Invalid day"
        }
    )
}