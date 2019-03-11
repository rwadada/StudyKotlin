package geometry.view

// 3.3.4 拡張関数をオーバーライドできない
open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() {
        println("Button clicked")
    }
}

fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")