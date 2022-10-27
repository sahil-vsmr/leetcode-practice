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
    
    List<List<Integer>> nodeList = new ArrayList();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return nodeList;
        } else {
            addToList(root, 0);
        }
        return nodeList;
    }
    
    public void addToList(TreeNode node, int level) {
        if (node != null) {
            if (nodeList.size() <= level) {
                nodeList.add(new ArrayList<>(Arrays.asList(node.val)));
            } else {
                nodeList.get(level).add(node.val);   
            }
            addToList(node.left, level + 1);
            addToList(node.right, level + 1);
        }
    }
}