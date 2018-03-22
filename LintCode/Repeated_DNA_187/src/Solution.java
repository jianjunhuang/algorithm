import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
Return:
["AAAAACCCCC", "CCCCCAAAAA"].

*/
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList(repeated);
    }

//    private int[] getNextArray(String str) {
//        char[] ch = str.toCharArray();
//        int[] next = new int[str.length()];
//        next[0] = -1;
//        int i = 0, j = -1;
//        while (i < str.length() - 1) {
//            if (j == -1 || ch[i] == ch[j]) {
//                i++;
//                j++;
//                next[i] = j;
//            } else {
//                j = next[j];
//            }
//        }
//        return next;
//    }
//
//    private int kmp(String originStr, String pattenStr, int[] next) {
//        int i = 0, j = 0;
//        char[] originCh = originStr.toCharArray();
//        char[] pattenCh = pattenStr.toCharArray();
//        while (i < originStr.length() && j < pattenStr.length()) {
//            if (j == -1 || originCh[i] == pattenCh[j]) {
//                i++;
//                j++;
//            } else {
//                j = next[j];
//            }
//        }
//        if (j == pattenStr.length()) {
//            return i - pattenStr.length();
//        } else {
//            return -1;
//        }
//    }

    public static void main(String args[]) {
        List<String> list = new Solution().findRepeatedDnaSequences("AAAAAAAAAAAA");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


}
