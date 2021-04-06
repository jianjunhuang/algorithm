import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubstring(String s, int k) {
        //sliding window
        int res = 0;
        for (int i = 1; i <= 26; i++) {
            res = Math.max(res, helper(s, i, k));
        }
        return res;
    }

    private int helper(String s, int m, int k) {
        int ans = 0;

        int left = 0, right = 0;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (; left < s.length(); left++) {

            while (right < s.length() && map.size() <= m) {
                char c = s.charAt(right);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
                if (map.get(c) == k)
                    count++;
                if (map.size() == m && count == m) {
                    ans = Math.max(ans, right - left + 1);
                }
                right++;
            }
            char d = s.charAt(left);
            if (map.containsKey(d)) {
                int i = map.get(d);
                if (i == k) {
                    count--;
                }
                if (i - 1 == 0) {
                    map.remove(d);
                } else {
                    map.put(d, i - 1);
                }
            }

        }

        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestSubstring("ababacb"
                , 3));
    }
}
