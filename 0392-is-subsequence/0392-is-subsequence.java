class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int slow = 0, fast = 0;
        while (slow < s.length() && fast < t.length()){
            if (s.charAt(slow) == t.charAt(fast)) {
                slow++;
            }
            fast++;
        }
        
        return slow == s.length();
    }
}