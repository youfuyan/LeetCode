class Solution {
    public int myAtoi(String s) {
        long res = 0;
        int sign = 1;
        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == ' '){
            i++;
        }
        if (i == n) {
            return 0;
        }
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        if (i == n) {
            return 0;
        }
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            res = res * 10 + s.charAt(i) - '0';
            if (res > Integer.MAX_VALUE) {
                break;
            }
            i++;
        }
        if ((int) res != res) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        return (int) res * sign;
    }
}