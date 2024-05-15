fun main(args: Array<String>) {
    val time = args[0]
    val hours = time.split(":")[0].toInt() ?: 0

    println("Good ${if (hours < 12) "morning" else "night"}, Kotlin")

    // oneliner
    println("Good ${if ((time.split(":")[0].toInt() ?: 0) < 12) "morning" else "night"}, Kotlin")

    // Fish feeding machine
    feedFish(randomDay())
    swim(50)
    swim(50, "slow")
    swim(time = 50, speed = "super slow")
    println(canAddFish(10.0, listOf(3, 3, 3)))
    println(canAddFish(8.0, listOf(2, 2, 2), hasDecorations = false))
    println(canAddFish(9.0, listOf(1, 1, 3), 3))
    println(canAddFish(10.0, listOf(), 7, true))
    
    // Filters
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    println(decorations.filter { it[0] == 'p' })

    // Fortune cookie
    println("Your fortune is: ${getFortuneCookie(getBirthday())}")
}

fun eagerExample() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    val eager = decorations.filter { it[0] == 'p' }
    println(eager) // prints [pagoda, plastic plant, flowerpot], not lazy

    // apply filter lazily
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println(filtered)
    println(filtered.toList())
    
    // apply map lazily
    var lazyMap = decorations.asSequence().map {
        println("map $it")
        it
    } 
    
    println(lazyMap)
    println("first: ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")
}

fun getFortuneCookie(birthday: Int): String {
    val fortunes = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )

    return when (birthday) {
        in 1..7 -> fortunes[0]
        28 -> fortunes[1]
        31 -> fortunes[2]
        else -> fortunes[birthday.rem(fortunes.size)]
    }
}

fun getBirthday(): Int {
    print("Enter your birthday: ")
    return readlnOrNull()?.toIntOrNull() ?: 1
}

fun feedFish(day: String) {
    val food = fishFood(day)

    println("Today is $day and the fish are going to eat $food")

    if (shouldChangeWater(day)) println("Change your water today")
}

fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week.random()
}

fun fishFood(day: String): String {
//    var food = "fasting"
//    when (day) {
//        "Monday" -> food = "flakes"
//        "Tuesday" -> food = "pellets"
//        "Wednesday" -> food = "redworms"
//        "Thursday" -> food = "granules"
//        "Friday" -> food = "mosquitoes"
//        "Saturday" -> food = "lettuce"
//        "Sunday" -> food = "plankton"
//    }
//    
//    return food

    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun swim(time: Int, speed: String = "fast") {
    println("swimming $speed for $time minutes")
}

fun getDirtySensorReading(): Int = 20

// Avoid passing expensive functions as default parameters as these will be evaluated at call time
// if the function using the default parameter function is called a lot, it can create an out of memory error
fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = getDirtySensorReading()): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}
