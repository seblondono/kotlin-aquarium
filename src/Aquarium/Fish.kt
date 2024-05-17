package Aquarium

class Fish(val frienly: Boolean = true, volumeNeeded: Int) {
    val size: Int

    // There can be many initializers and they always run before any secondary constructor
    init {
        println("Fish init")
    }

    // Most classes do not need a secondary constructor, but if they do, they need to include a call to the
    // primary constructor with "this"
    constructor() : this(true, 9) {
        println("Secondary constructor called")
    }

    // This works just as a constructor, and we can put logic in it to initialize our properties
    init {
        if (frienly) {
            size = volumeNeeded
        } else {
            size = volumeNeeded * 2
        }
    }

    init {
        println("constructed fish of size $volumeNeeded final size ${this.size}")
    }

    init {
        println("last init block")
    }

    fun move() = println("move")
    fun eat() = println("eat")
}

// An alternative to second constructors is to create a helper method
// like this, the class can stay simpler and with a cleaner API
fun makeDefaultFish() = Fish(true, 50)

fun fishExample() {
    val fish = Fish(true, 20)
    println("Is the fish friendly? ${fish.frienly}. It needs a volume of ${fish.size} cm3")
}

// Abstract classes and interfaces
// Abstract classes can have constructors, but they cannot be instantiated
// Interfaces cannot have constructors
// both can contain implementation of methods

// when you have a lot of methods but 1 or 2 default implementations => use interfaces
// anytime you cannot complete a class => use abstract classes
// in the case of AquariumFish, there is no real good default for the color, which means it needs to be abstract

// Interface delegation
// let's you add features to a class via composition
// we need an object that knows how to provide a fish color

// "object" before the class means, that this can only have one instance, doesn't make sense to have more than
// one instance of GoldColor (Singleton pattern)
object GoldColor : FishColor {
    override val color = "gold"
}

object RedColor : FishColor {
    override val color = "red"
}

//abstract class AquariumFish {
//    abstract val color: String
//}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

class Shark : FishColor, FishAction by PrintingFishAction("Hunt and eat fish") { // before inherited from AquariumFish
    override val color: String
        get() = "gray"
}

// Does not have a body, everything is handled via interface delegation
// consider using this powerful pattern whenever you would use an abstract class in other languages
class Plecostomus(fishColor: FishColor = GoldColor) : FishColor by fishColor,
    FishAction by PrintingFishAction("munch on algae")

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}