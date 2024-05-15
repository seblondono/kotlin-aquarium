fun main() {
    fun print(a: Int) {
        println(a)
    }

    /* Operators and Numbers */

    val clownFish = 1
    val blackFish = 1

    print(clownFish + blackFish)

    val initialFishAmount = 53
    val deadFishAmount = 10

    print(initialFishAmount - deadFishAmount)

    val ratioOfAliveFish = initialFishAmount / deadFishAmount

    print(ratioOfAliveFish) // integer result int/int = 5

    // or initialFishAmount = 53.0 & deadFishAmount = 10.0
    val ratioOfAliveFishAsDouble = initialFishAmount.toDouble() / deadFishAmount.toDouble()

    print(ratioOfAliveFishAsDouble) // integer result int/int = 5.3

    val fishAfterOneMonth = (initialFishAmount - deadFishAmount) * 300

    print(fishAfterOneMonth)

    // Kotlin keeps numbers as primitives by default
    initialFishAmount.times(300)
    initialFishAmount.toDouble().div(deadFishAmount.toDouble())
    initialFishAmount.minus(deadFishAmount)

    // use primitive int as an object
    1.toLong()

    // or, put it in a box
    val boxed: Number = 1
    boxed.toLong()

    /* Variables */

    val permanentValue = 1
    // permanentValue = 5 gives error

    var changableValue = 1 // type is inferred to int
    changableValue = 5
    // changableValue = 5.0 gives error
    
    // Casting
    changableValue = 5.0.toInt()
    
    // Number for matting for more readability
    val oneMillion = 1_000_000 // int
    
    /* Nullability */
    
    val nullableValue: Int? = null
    
    var lotsOfFish: List<String?> = listOf(null, null) // list of nullable Strings (list is none-nullable)
    
    var evenMoreFish: List<String>? = null // nullable list, if not null, then strings must be none-null
    
    var definitelyFish: List<String?>? = null
    
    // Not NULL assertion
    val goldFish: Int? = null
    
    goldFish!!.plus(1) 
    
    // Check for nullability
    
    val fishTreats = goldFish?.dec() ?: 0 // ?: elvis operator
}