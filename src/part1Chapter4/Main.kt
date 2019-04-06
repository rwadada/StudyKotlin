package part1Chapter4

import part1Chapter4.classHierarchyDefinition.Button

/**
 * 第4章
 * クラス、オブジェクト、インターフェイス
 */
fun main(args: Array<String>) {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}