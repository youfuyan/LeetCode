class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int left = 0, right = 0;
        int maxf = 0;
        int res = 0;
        while (right < s.length()) {
            arr[s.charAt(right) - 'A']++;
            maxf = Math.max(maxf, arr[s.charAt(right) - 'A']);
            right++;
            while (right - left - maxf > k) {
                arr[s.charAt(left) -'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}