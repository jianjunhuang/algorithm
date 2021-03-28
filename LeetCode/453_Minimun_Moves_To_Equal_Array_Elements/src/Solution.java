public class Solution {
    public static void main(String args[]) {
    }

    /*
    sum: the sum of all the numbers
    minNum: the min number int the list
    n: the length of the list
    m: moves
    x: all the numbers

    sum + moves * (n-1) = x * n
    x = minNum + moves
    > https://leetcode.com/problems/minimum-moves-to-equal-array-elements/discuss/93817/It-is-a-math-question
     */
    public int minMoves(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (min > num) {
                min = num;
            }
        }
        return sum - min * nums.length;
    }

}
