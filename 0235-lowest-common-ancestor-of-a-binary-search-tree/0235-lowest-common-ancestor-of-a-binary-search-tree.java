/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    List<TreeNode> ancestorListP = new ArrayList<TreeNode>();
    List<TreeNode> ancestorListQ = new ArrayList<TreeNode>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode currentNode = root;
        while (currentNode != p) {
            ancestorListP.add(currentNode);
            if (currentNode.val > p.val) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        ancestorListP.add(p);
        
        
        currentNode = root;
        while (currentNode != q) {
            ancestorListQ.add(currentNode);
            if (currentNode.val > q.val) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        ancestorListQ.add(q);
        
        //Collections.reverse(ancestorListQ);
        Collections.reverse(ancestorListP);
        
        /*for (TreeNode node: ancestorListQ) {
            System.out.print(node.val + " ");
        }
        System.out.println("End");*/
        for (TreeNode node: ancestorListP) {
            //System.out.print(node.val + " ");
            if (ancestorListQ.contains(node)) {
                return node;
            }
        }
        return null;
    }
}