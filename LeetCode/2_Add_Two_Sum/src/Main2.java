/**
 * clean code
 *
 *
 *
 *
 */
public class Main2 {
    public static void main(String args[]) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode node = addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
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
        ListNode head = null, node = null;
        boolean tag = false;
        while (l1 != null || l2 != null) {
            int num;
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            num = tag ? v1 + v2 + 1 : v1 + v2;

            if (num >= 10) {
                num = num % 10;
                tag = true;
            } else {
                tag = false;
            }

            if (node == null) {
                node = new ListNode(num);
            } else {
                node = node.next = new ListNode(num);
            }

            if (head == null) {
                head = node;
            }

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (tag) {
            node.next = new ListNode(1);
        }
        return head;
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

}
