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
    public int diameterOfBinaryTree(TreeNode root) {
        int left = root.left != null ? getHeight(root.left, 0) : 0;
        int right = root.right != null ? getHeight(root.right, 0): 0;
        if (result < left + right) {
            result = left+right;
        }
        if (root.left != null) {
            diameterOfBinaryTree(root.left);
        } 
        if (root.right != null) {
            diameterOfBinaryTree(root.right);
        }
        return result;
    }
    
    int getHeight(TreeNode node, int height) {
        if (node == null) {
            return height;
        }
        int heightLeft = getHeight(node.left, height+1);
        int heightRight = getHeight(node.right, height+1);
        
        return Math.max(heightLeft, heightRight);
    }
}