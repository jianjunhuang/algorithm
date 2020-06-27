import kotlin.collections.ArrayDeque

class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        s.forEach {
            when (it) {
                '{', '(', '[' -> {
                    stack.add(it)
                }
                '}', ')', ']' -> {
                    if (stack.isEmpty()) return false
                    stack.removeLastOrNull()?.let { c ->
                        if (c == '{' && it != '}') return false
                        if (c == '(' && it != ')') return false
                        if (c == '[' && it != ']') return false
                    }
                }
            }
        }
        return true
    }
}