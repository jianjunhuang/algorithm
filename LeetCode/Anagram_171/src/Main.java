import java.util.*;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/11/20
 *
 *
 * 给出一个字符串数组S，找到其中所有的乱序字符串(Anagram)。如果一个字符串是乱序字符串，那么他存在一个字母集合相同，但顺序不同的字符串也在S中。（uber ，facebook）
 *
 *
 * 样例
 * 对于字符串数组 ["lint","intl","inlt","code"]
 * 返回 ["lint","inlt","intl"]
 *
 * LeetCode 中也有
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 */
public class Main {
    public static void main(String args[]) {
        String[] strs = {"ate", "eat", "abd"};
        Solution solution = new Solution();
        List<String> mList = solution.anagrams(strs);
        for (String str : mList) {
            System.out.println(str);
        }
    }

    public static class Solution {
        /*
         * @param strs: A list of strings
         * @return: A list of strings
         */
        public List<String> anagrams(String[] strs) {
            List<String> resultList = new ArrayList<>();
            if (strs.length == 0) {
                return resultList;
            }
            Map<String, List<String>> mMap = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                char chs[] = str.toCharArray();
                Arrays.sort(chs);
                String key = Arrays.toString(chs);
                if (mMap.containsKey(key)) {
                    List<String> mTempList = mMap.get(key);
                    mTempList.add(str);
                } else {
                    List<String> mTempList = new ArrayList<>();
                    mTempList.add(str);
                    mMap.put(key, mTempList);
                }
            }
            for (Map.Entry<String, List<String>> entry : mMap.entrySet()) {
                if (entry.getValue().size() > 1) {
                    resultList.addAll(entry.getValue());
                }
            }

            return resultList;
        }
    }


}
