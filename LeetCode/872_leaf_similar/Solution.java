import java.util.ArrayList;
import java.util.List;

//pass 54%
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List list1 = new ArrayList<Integer>();
        List list2 = new ArrayList<Integer>();
        traverseTree(list1, root1);
        traverseTree(list2, root2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void traverseTree(List<Integer> leftList, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leftList.add(node.val);
            return;
        }
        traverseTree(leftList, node.left);
        traverseTree(leftList, node.right);
    }
}
