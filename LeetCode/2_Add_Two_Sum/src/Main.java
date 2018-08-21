public class Main {
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

}
