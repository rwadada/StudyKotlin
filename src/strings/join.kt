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

// 3.3 他人のクラスにメソッドを追加する：拡張関数と拡張プロパティ
fun String.lastChar(): Char = this.get(this.length - 1)