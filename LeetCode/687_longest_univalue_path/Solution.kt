import java.util.ArrayDeque

/*
Given a binary tree, find the length of the longest path where each node in the path has the same value.、
 This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.

input ->
              5
             / \
            4   5
           / \   \
          1   1   5

output 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-univalue-path
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


注意 ·This path may or may not pass through the root· ，然后分情况递归
 */
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 *
 *
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun longestUnivaluePath(root: TreeNode?): Int {
        ans = 0
        longPath(root)
        return ans
    }

    var ans = 0
    private fun longPath(root: TreeNode?): Int {
        var longest = 0
        if (root == null) {
            return longest
        }
        val left = longPath(root.left)
        val right = longPath(root.right)
        /*
         *      1
         *     / \
         *    1   1
         */
        if (root.left != null && root.right != null && root.left?.`val` == root.`val` && root.right?.`val` == root.`val`) {
            ans = Math.max(ans, left + right + 2)
        }
        /*
               1
              /
             1
         */
        if (root.left != null && root.left?.`val` == root.`val`) {
            longest = left + 1
        }
        /*
               1
                \
                 1
        */
        if (root.right != null && root.right?.`val` == root.`val`) {
            longest = Math.max(longest, right + 1)
        }
        ans = Math.max(ans, longest)
        return longest
    }
}

fun main(args: Array<String>) {

}
