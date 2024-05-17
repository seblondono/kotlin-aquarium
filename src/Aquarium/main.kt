package Aquarium

fun main (args: Array<String>) {
    buildAquarium()
    makeFish()
}

// making this function private will make it available only in this file
// making this function internal will only make it visible to the same module (set of files compiled together)
fun buildAquarium() {
    val myAquarium = Aquarium()
    println("Length: ${myAquarium.length} " +
            "Width: ${myAquarium.width} " +
            "Height: ${myAquarium.height}")
    
    myAquarium.height = 80
    println("Height: ${myAquarium.height}")
    println("Volume: ${myAquarium.volume}")
    
    val smallAquarium = Aquarium(length = 20, width = 15, height = 30)
    println("Small Aquarium volume: ${smallAquarium.volume}")
    
    val myAquarium2 = Aquarium(numberOfFish = 29)
    println("Small Aquarium 2: ${myAquarium2.volume} liters with " +
        "length ${myAquarium2.length} " +
        "width ${myAquarium2.width} " +
        "height ${myAquarium2.height} "
    )
}

fun makeFish() {
    val shark = Shark()
    println("Shark color is ${shark.color}")
    shark.eat()
    
    val plecostomus = Plecostomus()
    println("Plecostomus color is ${plecostomus.color}")
    plecostomus.eat()
}

fun feedFish(fish: FishAction) {
    fish.eat()
}

// Abstract classes and interfaces
fun delegate() {
    val pleco = Plecostomus()
    println("Plecostomus color is ${pleco.color}")
    pleco.eat()
}