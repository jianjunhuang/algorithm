class Solution {
    public int orchestraLayout(int num, int xPos, int yPos) {
        //二维数组旋转遍历， 直接找关系
        int ans = (int) dfs(num, xPos, yPos);
        System.out.println(ans);
        return ans % 9 == 0 ? 9 : ans % 9;
    }

    private long dfs(long num, long xPos, long yPos) {
        //终止条件

        if (xPos == 0) return yPos + 1;
        if (yPos == num - 1) return xPos + num;
        if (xPos == num - 1) return num + num - 1 + (num - yPos - 1);
        if (yPos == 0) {
            return num * 2 + (num - 2) * 2 - xPos + 1;
        }
        /*
        1 -> 1
        2 -> 4
        3 -> 8
        4 -> 12
        5 -> 17
        */
        long n = num * 2 + (num - 2) * 2;
        return (n + dfs(num - 2, xPos - 1, yPos - 1));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.orchestraLayout(449572,
                209397,
                306801));
    }
}