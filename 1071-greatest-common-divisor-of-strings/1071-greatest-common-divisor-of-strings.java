class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcdLen = gcd(str1.length(), str2.length());
        
        return str1.substring(0, gcdLen);
    }
    private int gcd(int m, int n) {
       if (n == 0) {
           return m;
       } else {
           return gcd(n, m % n);
       }
    }
}