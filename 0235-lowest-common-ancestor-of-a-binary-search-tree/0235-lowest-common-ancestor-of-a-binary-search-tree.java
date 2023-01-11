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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;
        
        TreeNode node = root;
        while (node != null){
            int parentVal = node.val;
            if (pVal < parentVal && qVal < parentVal) {
                node = node.left;
            } else if (pVal > parentVal && qVal > parentVal) {
                node = node.right;
            } else {
                return node;
            }
        }
       return null; 
    }
}