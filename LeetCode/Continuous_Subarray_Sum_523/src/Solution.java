public class Solution {
    //non-negative
    //至少有连续的两个数和是 k 的倍数
    //动态规划？
    public static boolean checkSubarraySum(int[] nums, int k) {

        if (nums == null || nums.length < 2) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sum += nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if ((k != 0 && sum % k == 0) || (k == 0 && sum == 0)) {
                    return true;
                }
            }
            sum = 0;
        }

        return false;
    }
//O(n) time O(k) space
// a[i]+a[i+1]+...+a[j]=(n1)k+q;
// n>j且a[i]+a[i+1]+...+a[j]+...+a[n]=(n2)k+q;
// a[j+1]+...+a[n]=(n2−n1)k
//    public boolean checkSubarraySum(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
//        int runningSum = 0;
//        for (int i=0;i<nums.length;i++) {
//            runningSum += nums[i];
//            if (k != 0) runningSum %= k;
//            Integer prev = map.get(runningSum);
//            if (prev != null) {
//                if (i - prev > 1) return true;
//            }
//            else map.put(runningSum, i);
//        }
//        return false;
//    }

    public static void main(String args[]) {
        System.out.println(checkSubarraySum(new int[]{0, 1, 0}, 0));
    }


}
