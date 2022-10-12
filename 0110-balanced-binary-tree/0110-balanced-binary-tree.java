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
    public boolean isBalanced(TreeNode root) {
        int left = 0;
        int right = 0;
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            left = getHeight(root.left, left+1);   
        }
        if (root.right != null) {
            right = getHeight(root.right, right+1);   
        }
        //System.out.println(left);
        //System.out.println(right);
        return Math.abs(left-right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int getHeight(TreeNode node, int height) {
        int heightLeft = 0;
        int heightRight = 0;
        
        if (node.left != null || node.right != null) {
            height++;
        }
        if (node.left != null) {
            heightLeft = getHeight(node.left, height);   
        }
        if (node.right != null) {
            heightRight = getHeight(node.right, height);
        }
        return Math.max(height, Math.max(heightLeft, heightRight));
    }
}