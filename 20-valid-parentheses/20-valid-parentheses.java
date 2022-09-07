class Solution {
    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                left.push(c);
            } else { // c is right parenthese
                if (!left.isEmpty() && leftOf(c) == left.peek()) {
                    left.pop();
                } else {
                    return false;
                }
            }
        }
        return left.isEmpty(); //check if all left parentese has been match or not
    }
    
    private char leftOf(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
        
    }
}