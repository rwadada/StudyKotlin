fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        println("Hello, ${args[0]}")
    }

    println(Person("Bob", true))
}

fun max(a: Int, b: Int): Int = if (a > b) a else b