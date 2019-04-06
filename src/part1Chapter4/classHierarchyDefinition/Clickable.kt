package part1Chapter4.classHierarchyDefinition

/**
 * 4.1 クラス階層の定義
 * 4.1.1 Kotlinのインターフェイス
 */
interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}