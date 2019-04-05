/**
 * ファイルクラス名の変更
 *
 * Kotlinのトップレベル関数を含む、生成されたクラスの名前を変更するには、ファイルに@JvmNameアノテーションを追加します。
 * ファイルの冒頭、すなわちパッケージ名の前にアノテーションをおいてください。
 */

@file:JvmName("StringFunctions")

package strings

import java.lang.StringBuilder

// 3.3.3 拡張としてのユーティリティ関数
fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

// 3.3.5 拡張プロパティ
val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        setCharAt(length - 1, value)
    }

// 3.5.2 正規表現とトリプルクォート文字列
fun pursePath(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (
        directory,
        filename,
        extension
        ) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }

}