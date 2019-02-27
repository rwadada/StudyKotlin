package geometry.example

import geometry.Color
import geometry.Color.*
import geometry.Person
import geometry.shapes.Rectangle
import java.lang.Exception


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

    println(mix(BLUE, YELLOW))
    println(mix(RED, INDIGO))
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

fun mix(c1: Color, c2: Color): Color =
        when (setOf(c1, c2)) {
            setOf(RED, YELLOW) -> ORANGE
            setOf(YELLOW, BLUE) -> GREEN
            setOf(BLUE, VIOLET) -> INDIGO
            else -> throw Exception("Dirty color")
        }