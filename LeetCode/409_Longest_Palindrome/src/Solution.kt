class Solution {
    fun longestPalindrome(s: String): Int {
        val a = IntArray(128)
        var ans = 0
        for (c in s) {
            a[c.toInt()]++
        }
        a.forEach {
            ans += (it / 2) * 2
            if (it % 2 == 1 && ans % 2 == 0) {//后面出现奇数都是一样的了，不需要再加一
                ans++
            }
        }
        return ans
    }
}