package geometry.example

import geometry.Color
import geometry.Color.*
import geometry.Expr
import geometry.Person
import geometry.shapes.Rectangle
import java.lang.Exception
import java.util.*


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

    println(mixOptimized(BLUE, YELLOW))

    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))

    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))

    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

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

fun mixOptimized(c1: Color, c2: Color): Color =
        when {
            (c1 == RED && c2 == YELLOW) ||
            (c1 == YELLOW && c2 == RED) ->
                ORANGE

            (c1 == YELLOW && c2 == BLUE) ||
            (c1 == BLUE && c2 == YELLOW) ->
                GREEN

            (c1 == BLUE && c2 == VIOLET) ||
            (c1 == VIOLET && c2 == BLUE) ->
                INDIGO

            else -> throw Exception("Dirty color")
        }

fun eval(e: Expr): Int =
        when (e){
            is Num -> e.value
            is Sum -> {
                eval(e.right) + eval(e.left)
            }
            else -> throw IllegalArgumentException("Unknown expression")
        }

fun evalWithLogging(e: Expr): Int =
        when (e) {
            is Num -> {
                println("num: ${e.value}")
                e.value
            }
            is Sum -> {
                val left = evalWithLogging(e.left)
                val right = evalWithLogging(e.right)
                println("sum: $left + $right")
                left + right
            }
            else -> throw IllegalArgumentException("Unknown expression")
        }

class Num(val value: Int): Expr

class Sum(val left: Expr, val right: Expr): Expr