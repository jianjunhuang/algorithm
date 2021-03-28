import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 27ms
 */
public class Main {
    public static void main(String args[]) {
       System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        if (null == l1 && null != l2) {
            head.val = l2.val;
        }
        if (null == l2 && null != l1) {
            head.val = l1.val;
        }

        ListNode node = head;
        boolean tag = false;
        while (null != l1 && null != l2) {
            int num = l1.val + l2.val;
            if (tag) {
                num++;
            }
            if (num >= 10) {
                num = num % 10;
                tag = true;
            } else {
                tag = false;
            }
            node.next = new ListNode(num);
            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }
        while (null != l1) {
            int num = l1.val;
            if (tag) {
                num++;
            }
            if (num >= 10) {
                num = num % 10;
                tag = true;
            } else {
                tag = false;
            }
            node = node.next = new ListNode(num);
            l1 = l1.next;
        }
        while (null != l2) {
            int num = l2.val;
            if (tag) {
                num++;
            }
            if (num >= 10) {
                num = num % 10;
                tag = true;
            } else {
                tag = false;
            }
            node = node.next = new ListNode(num);
            l2 = l2.next;
        }
        if (tag) {
            node = node.next = new ListNode(1);
        }
        return head.next;
    }

    //    Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "  " + next;
        }
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList();
            if (nums == null || nums.length == 0) {
                return res;
            }
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                int l = i+1, r = nums.length - 1;
                if (i > 0 && nums[i] == nums[i-1]) continue;
                int tar = nums[i];
                while (l < r) {
                    int tmp = nums[l] + nums[r];
                    if (tar + tmp == 0) {
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (tar + tmp < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
            return res;
        }
    }
}
