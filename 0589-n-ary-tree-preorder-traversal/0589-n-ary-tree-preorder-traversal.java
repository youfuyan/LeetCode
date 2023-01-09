/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> res = new LinkedList<>();
    
    public List<Integer> preorder(Node root) {
        traverse(root);
        return res;
    }
    
    public void traverse(Node root) {
        if (root == null) {
            return;
        }
        //preorder
        res.add(root.val);
        for (Node child : root.children) {
            traverse(child);
        }
        //postorder
    }
    
}