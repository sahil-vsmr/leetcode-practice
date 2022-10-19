/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result = -1;
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        getDepth(root, 0);
        return result;
    }
    public void getDepth(TreeNode node, int depth) {
        if (node == null) {
            if (result < depth) {
                result = depth;
            }
            return;
        }
        
        getDepth(node.left, depth+1);
        getDepth(node.right, depth+1);
        
    }
}