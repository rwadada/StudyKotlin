package geometry.example

import geometry.Color
import geometry.Person
import geometry.shapes.Rectangle


fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        println("Hello, ${args[0]}")
    }

    println(Person("Bob", true))
    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)

    println(Color.BLUE.rgb())
}

fun max(a: Int, b: Int): Int = if (a > b) a else b