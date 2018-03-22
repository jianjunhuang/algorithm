import java.util.Stack;

public class Solution {
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stacks = new Stack<>();
        TreeNode p = root;
        int count = 0;
        while (!stacks.empty() || p != null) {
            if (p != null) {
                stacks.push(p);
                p = p.left;
            } else {
                TreeNode node = stacks.pop();
                if (++count == k) {
                    return node.val;
                }
                p = node.right;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        System.out.println(kthSmallest(root,2));
    }
}
