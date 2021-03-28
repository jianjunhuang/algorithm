import java.util.HashMap;
import java.util.Map;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap();
        int result = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;

            Integer i = map.get(c);
            if(i == null) {
                map.put(c, 1);
            } else {
                map.put(c, i+1);
            }

            while (map.get(c) > 1) {
                //shrike
                char d = s.charAt(left);
                left++;
                Integer l = map.get(d);
                if (l != null) {
                    map.put(d, l-1);
                }
            }
			System.out.println(s.substring(left, right));
	        result = Math.max(result, right - left);
        }
    return result;
    }

    public static void main(String args[]) {
        new Solution().lengthOfLongestSubstring("abcabcbb");
    }
}
