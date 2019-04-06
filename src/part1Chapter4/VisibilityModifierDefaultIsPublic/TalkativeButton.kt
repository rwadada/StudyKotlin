package part1Chapter4.VisibilityModifierDefaultIsPublic

import part1Chapter4.classHierarchyDefinition.Focusable

/**
 * 4.1.3 可視性修飾子：デフォルトはpublic
 */
internal open class TalkativeButton: Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

// Can't
//fun TalkativeButton.giveSpeach() {
//    yell()
//
//    whisper()
//}