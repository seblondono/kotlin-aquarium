const val rocks = 3 // value is determined at compile time
// i.e. cannot be assigned the return value of a function
// works only at top level and in classes defined with "object" not with "class"

object Constants {
    const val rocks = 5
}
val foo = Constants.rocks

class MyClass {
    // class level constants
    // difference between companion objects and regular objects
    //   1. companion objects are initialized from the static constructor of the containing class (created when 
    //   object is created)
    //   2. regular objects are initialized lazily on the first access to the object (on first use)
    companion object {
        const val rocks = 3
    }
}



fun main(args: Array<String>) {
    // 
    println(rocks)
    
    val number = 5 // value can be determined during program execution
    // can be assigned the return value of a function
}