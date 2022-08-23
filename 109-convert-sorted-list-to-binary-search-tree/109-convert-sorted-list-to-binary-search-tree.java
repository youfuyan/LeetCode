/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        for (ListNode p = head; p != null; p = p.next) {
            len++;
        } 
        cur = head;
        return inorderBuild(0, len - 1);
    }
    
    private TreeNode inorderBuild(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode leftTree = inorderBuild(left, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode rightTree = inorderBuild(mid + 1, right);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
    //Time: O(n)
    //Space: O(logN)
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}