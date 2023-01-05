class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sint = new int[256];
        int[] tint = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (sint[s.charAt(i)] != tint[t.charAt(i)]) return false;
            sint[s.charAt(i)] = i + 1;
            tint[t.charAt(i)] = i + 1;
        }
        return true;
    }
}