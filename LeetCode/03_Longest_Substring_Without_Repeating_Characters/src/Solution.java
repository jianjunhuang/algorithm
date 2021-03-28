import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> mMap = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (mMap.containsKey(s.charAt(j))) {
                i = Math.max(mMap.get(s.charAt(j)), i);
            }
            mMap.put(s.charAt(j), j + 1);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
