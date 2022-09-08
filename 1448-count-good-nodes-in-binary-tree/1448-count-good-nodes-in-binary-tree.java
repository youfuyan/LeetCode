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
    int count = 0;
    public int goodNodes(TreeNode root) {
        
        traverse(root, root.val);
        return count;
    }
    
    public void traverse(TreeNode root, int pathMax) {
        if (root ==null) {
            return;
        }
        
        if (root.val >= pathMax) {
            count++;
        }
        pathMax = Math.max(root.val, pathMax);
        traverse(root.left, pathMax);
        traverse(root.right, pathMax);
    }
}