class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        HashSet<Character> hs = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                hs.remove(s.charAt(i));
                count += 2;
            } else {
                hs.add(s.charAt(i));
            }
        }
        if (hs.size() > 0) {
            count++;
        }
        return count;
    }
}