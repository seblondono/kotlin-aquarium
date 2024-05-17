package Aquarium

import kotlin.math.PI

// In Kotlin everything is public by default, all variables and classes declarations can
// be accessed everywhere

/* Class visibility
*   public -> default. Class and public members are visible everywhere
*   private -> inside class. Subclasses cannot see
*   protected -> inside class. Subclasses CAN see
*   internal -> inside the same module
* */
// open allows to create a subclass
open class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    // properties are initialized in the order they are defined
    open var water = volume * 0.9

    constructor(numberOfFish: Int) : this() {
        val water = numberOfFish * 2000 // cm3
        val tank = water + water * 0.1
        height = (tank / (length * width)).toInt()
    }
}

class TowerTank : Aquarium() {  // inherit from Aquarium class, i.e. TowerTank
    override var water = volume * 0.8

    override var volume: Int
        get() = (width * height * length / 1000 * PI).toInt()
        set(value) {
            height = (value * 1000) / (width * length)
        }
}