fun main() {
    // 1
    var fish = 2.plus(71).plus(233).minus(13) // 293
    
    val numberOfAquariums = fish / 30 // 9
    
    // 2
    var rainbowColor = "green"
    rainbowColor = "blue"
    val blackColor = "black"
    
    // 3
    var greenColor: String? = null
    var blueColor = null
    
    // 4
    val nullList1 = listOf(null, null)
    val nullList2: Array<Any?> = arrayOf(null, null)
    val nullList3: List<Any>? = null
    
    // 5
    var nullTest: Int? = null
    println(nullTest?.plus(1) ?: 0)
}