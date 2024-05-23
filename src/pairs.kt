fun main(args: Array<String>) {
    val equipment = "fishnet" to "sailboat"
    println(equipment.first)
    println(equipment.second)
    
    // can be nested
    val equip = ("fishnet" to "catching fish") to ("sailboat" to "sailing")
    println(equip.first.first)
    println(equip.first.second)
    println(equip.second.first)
    println(equip.second.second)
    
    // cen be destructed
    val fishnet = "fishnet" to "catching fish"
    val (tool, use) = fishnet
    println(tool)
    println(use)
    
    // can be turned into string
    println(fishnet.toString())
    
    // can be turned into a list
    println(fishnet.toList())
    
    // there is also a triple
    val (a, b, c) = Triple(2, "x", listOf(null))
    println(a) // 2
    println(b) // x
    println(c) // [null]
}