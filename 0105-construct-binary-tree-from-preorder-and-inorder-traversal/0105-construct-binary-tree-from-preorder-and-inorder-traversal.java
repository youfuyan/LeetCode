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
    
    Map<Integer, Integer> valToIdx = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1 || inorder.length < 1) return null;
        
        for (int i = 0; i < inorder.length; i++) {
            valToIdx.put(inorder[i], i);
        }
        
        return builder(preorder, 0, 0, inorder.length - 1);
    }
    
    public TreeNode builder(int[] preorder, int preorderIdx, int inorderLow, int inorderHigh) {
        if (preorderIdx > preorder.length - 1 || inorderLow > inorderHigh) return null;
        
        int currentVal = preorder[preorderIdx];
        TreeNode n = new TreeNode(currentVal);
        int mid = valToIdx.get(currentVal);
        
        n.left = builder(preorder, preorderIdx + 1, inorderLow, mid - 1);
        n.right = builder(preorder, preorderIdx + (mid - inorderLow) + 1, mid + 1, inorderHigh);
        return n;
    }
}