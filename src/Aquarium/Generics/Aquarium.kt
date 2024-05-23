package Aquarium.Generics

open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() { 
        needsProcessed = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

open class Aquarium<T: WaterSupply>(val waterSupply: T) {
    fun addWater() {
        // throws an Illegal exemtion of the condition is false
        check(!waterSupply.needsProcessed) { "water supply needs processed" }
        println("adding water from ${waterSupply}")
    }
}

fun genericExample() {
    val aquarium = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()
    
    val lakeAquarium = Aquarium(LakeWater())
    lakeAquarium.waterSupply.filter()
    lakeAquarium.addWater()
}

// Out types are types parameters that only ever occur in return values of functions, or on val properties.
class AquariumOut<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessed)
            cleaner.clean(waterSupply)
        
        println("adding water from ${waterSupply}")
    }
    
    // To be able to use the generic R in an "is" check, we need to "reified" it (reified means real)
    // this tells Kotlin the type is real. Use the "inline" keyword before "fun" and add "reified" before
    // the generic R.
    // Non-reified types are only available at compile time, but can't be used at run time by the program
    inline fun <reified R: WaterSupply> hasWaterSupplyOfType() = waterSupply is R // T is R
}

// Star (*) projections. I do not care what type of generic the Aquarium takes
inline fun <reified R: WaterSupply> AquariumOut<*>.hasWaterSupplyOfTypeAny() = waterSupply is R
// Reified types can also be used in extension functions
inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

// Here Kotlin can ensure this function does nothing dangerous with the generic
fun addItemTo(aquariumOut: AquariumOut<WaterSupply>) = println("item added")

fun genericOutExample() {
    val cleaner = TapWaterCleaner()
    val aquarium = AquariumOut(TapWater())
    addItemTo(aquarium)
    aquarium.addWater(cleaner)
    isWaterClean(aquarium)
    aquarium.hasWaterSupplyOfType<TapWater>() // true
    aquarium.waterSupply.isOfType<TapWater>() // true
}

// In types can be used anytime the generic is only used as an argument to functions.
// they can only be passed into an object
interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

fun <T: WaterSupply>isWaterClean(aquarium: AquariumOut<T>) {
    println("aquarium water is clean: ${!aquarium.waterSupply.needsProcessed}")
}

// type erasure, only at compile time
// at run time all generic types are erased. That is why Kotlin added reified, so isChecks can be done safely

