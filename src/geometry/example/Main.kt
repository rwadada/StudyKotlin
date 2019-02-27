package geometry.example

import geometry.Color
import geometry.Color.*
import geometry.Person
import geometry.shapes.Rectangle


fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        println("Hello, ${args[0]}")
    }

    println(Person("Bob", true))
    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)

    println(BLUE.rgb())

    println(getMnemonic(BLUE))
    println(getWarms(ORANGE))
}

fun max(a: Int, b: Int): Int = if (a > b) a else b

fun getMnemonic(color: Color): String =
        when (color) {
            RED -> "Richard"
            ORANGE -> "Of"
            YELLOW -> "York"
            GREEN -> "Gave"
            BLUE -> "Battle"
            INDIGO -> "In"
            VIOLET -> "Vain"
        }

fun getWarms(color: Color): String =
        when(color) {
            RED, ORANGE, YELLOW -> "warm"
            GREEN -> "neutral"
            BLUE, INDIGO, VIOLET -> "cold"
        }