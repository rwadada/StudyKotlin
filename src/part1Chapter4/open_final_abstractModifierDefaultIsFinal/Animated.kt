package part1Chapter4.open_final_abstractModifierDefaultIsFinal

abstract class Animated {
    abstract fun animate()
    open fun stopAnimating() {}
    fun animateTwice() {}
}