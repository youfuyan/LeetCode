class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s.length();
        } 
        HashMap<Character, Integer> window = new HashMap<>(); 
        int left = 0;
        int right = 0;
        int len = -1;
        while (right < s.length()) {
            char chAdd = s.charAt(right);
            right++;
            window.put(chAdd, window.getOrDefault(chAdd, 0) + 1);
            while (window.get(chAdd) > 1) {
                char chRmv = s.charAt(left);
                left++;
                window.put(chRmv, window.get(chRmv) - 1);
            }
            len = Math.max(len, right - left);
        }
        return len;
    }
}