package Aquarium.Annotations

//import kotlin.reflect.full.declaredMemberFunctions
//import kotlin.reflect.full.findAnnotation

// Annotations are a means of attaching metadata to code
// they are read by the compiler and used to generate code or even logic
// they go right before the thing that is annotated, most things can be annotated
// classes, functions, methods, and even control structures
// some annotations can even take arguments
// they can target getter or setters

@ImAPlant class Plan {
    fun trim() {}
    fun fertilize() {}
    
    @get:OnGet
    val isGrowing = true
    
    @set:OnSet
    var needsFood = false
}

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

fun reflections() {
    val classObj = Plan::class
//    for (method in classObj.declaredMemberFunctions) println(method.name)

    val annotations = classObj.annotations
    println(annotations)
    
//    val annotated = classObj.findAnnotation<ImAPlant>()
//    annotated?.apply {
//        println("ImAPlant")
//    }
}