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
    LinkedList<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        maxDepth(root);
        return res;
    }
    
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int h = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        
        if (res.size() < h) {
            res.add(new LinkedList<>());
        }
        res.get(h - 1).add(root.val);
        return h;
    }
}