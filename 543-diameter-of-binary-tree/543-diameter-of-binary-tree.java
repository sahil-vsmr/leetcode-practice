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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }
    
    public int longestPath(TreeNode currentNode) {
        if(currentNode == null) return 0;
        
        int leftPath = longestPath(currentNode.left);
        int rightPath = longestPath(currentNode.right);
        
        diameter = Math.max(diameter, leftPath + rightPath);
        
        return Math.max(rightPath, leftPath) + 1;
    }
}