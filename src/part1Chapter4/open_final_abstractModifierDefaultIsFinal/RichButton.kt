package part1Chapter4.open_final_abstractModifierDefaultIsFinal

import part1Chapter4.classHierarchyDefinition.Clickable

/**
 * 4.1.2 open, final, abstract修飾子：デフォルトはfinal
 */

open class RichButton: Clickable {
    fun disable() {}

    open fun animate() {}

    final override fun click() {}
}