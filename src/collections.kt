fun main(args: Array<String>) {
    val symptoms = mutableListOf("cough", "fever", "sore throat")
    symptoms.add("headache")
    symptoms.remove("fever")
    println(symptoms)
    
    symptoms.contains("red spots") // false
    symptoms.contains("cough") // true
    
    println(symptoms.subList(2, symptoms.size)) // [headache, sore throat]
    
    symptoms.sort()
    println(symptoms)
    
    listOf(1, 5, 3).sum() // 9
    listOf(1, 5, 3).average() // 3
    
    listOf("a", "b", "cc").sumBy { it.length } // 4
    
    // maps
    val cures = mapOf("cough" to "syrup", "fever" to "cold shower")
    println(cures["fever"]) // cold shower
    println(cures.get("cough")) // syrup
    println(cures.getOrDefault("red spots", "no cure")) // no cure
    println(cures.getOrDefault("fever", "no cure")) // cold shower
    println(cures.getOrElse("red spots") { "no cure" }) // no cure
    println(cures.keys) // [cough, fever]
    println(cures.values) // [syrup, cold shower]
    println(cures.entries) // [(cough, syrup), (fever, cold shower)]
    
    // labeled breaks
    // gives us better control over nested loops
    // any expression can be marked with a label 
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (i > 10) break@loop
        }
    }
}