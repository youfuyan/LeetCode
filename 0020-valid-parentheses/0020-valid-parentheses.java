class Solution {
    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                left.push(c);
            } else if (!left.isEmpty() && leftOf(c) == left.peek()) {
                left.pop();
            } else {
                return false;
            }
        }
        return left.isEmpty();
    }
    
    private Character leftOf (Character c) {
        if (c == '}') {
            return '{';
        } else if (c == ')') {
            return '(';
        } else {
            return '[';
        }
    }
}