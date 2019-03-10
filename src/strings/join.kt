/**
 * ファイルクラス名の変更
 *
 * Kotlinのトップレベル関数を含む、生成されたクラスの名前を変更するには、ファイルに@JvmNameアノテーションを追加します。
 * ファイルの冒頭、すなわちパッケージ名の前にアノテーションをおいてください。
 */

@file:JvmName("StringFunctions")

package strings

import java.lang.StringBuilder

// 3.2.3 静的なユーティリティクラスをなくす：トップレベルの関数とプロパティ
fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}