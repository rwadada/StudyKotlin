fun main(args: Array<String>) {
    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello, $name")
}

fun max(a: Int, b: Int): Int = if (a > b) a else b