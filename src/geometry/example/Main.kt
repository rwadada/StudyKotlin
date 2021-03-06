package geometry.example

import geometry.Color
import geometry.Color.*
import geometry.Expr
import geometry.Person
import geometry.shapes.Rectangle
import geometry.view.Button
import strings.*
import java.lang.Exception
import java.util.*
import geometry.view.View
import geometry.view.showOff
import java.lang.StringBuilder

// 3.3.1 importと拡張関数
// asキーワードを使用することでインポートするクラスや関数名を変更できる！
import strings.lastChar as last


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

    println(isLetter('q'))
    println(isNotDigit('x'))

    correction()

    val list = listOf(1, 2, 3)
    println(list.joinToString("; ", "(", ")"))

    // 3.2.1 名前付き引数
    println(list.joinToString(
        separator = " ",
        prefix = " ",
        postfix = "."
    ))

    // 3.2.1 デフォルト引数
    println(list.joinToString())
    println(list.joinToString(separator =  "; "))

    // 3.3.1 こんな感じにね
    println("Kotlin".last())
    println("same as above : " + "Kotlin".get("Kotlin".length - 1))

    println(listOf("one", "two", "three").joinToString())
    println(listOf("four", "five", "six").join(" "))

    val view: View = Button()
    view.click()
    view.showOff()
    val button = Button()
    button.showOff()

    println("Kotlin".last)

    val sb = StringBuilder("Kotlin?")
    sb.last = '!'
    println(sb)

    // 3.5.1 文字列の分割
    // Kotlinの場合Javaと異なり正規表現なのかプレーンテキストなのかを明に宣言することができる。
    println("12.345-6.A".split("[.\\-]".toRegex()))
    println("12.345-6.A".split(".", "-"))

    // 3.5.2 正規表現とトリプルクォート文字列
    pursePath("/Users/yole/kotlin-book/chapter.adoc")

    // 3.5.3 複数行のトリプルクォート文字列
    val kotlinLogo = """| //
                       .|//
                       .|/ \"""
    println(kotlinLogo.trimMargin("."))
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

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun isNotDigit(c: Char) = c !in '0'..'9'

fun correction() {
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    val strings = listOf("first", "second", "fourteenth")

    println(strings.last())

    val numbers = setOf(1, 14, 2)

    println(numbers.max())
}

fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "{",
    postfix: String = "}"
) = joinToString(separator, prefix, postfix)
