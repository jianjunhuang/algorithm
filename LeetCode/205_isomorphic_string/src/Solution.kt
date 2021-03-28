class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val sArray = IntArray(256)
        val tArray = IntArray(256)
        for (index in s.indices) {
            val sc = s[index].toInt()
            val tc = t[index].toInt()
            if (sArray[sc] != tArray[tc]) {
                return false
            }
            sArray[sc] = index + 1
            tArray[tc] = index + 1
        }
        return true
    }
}