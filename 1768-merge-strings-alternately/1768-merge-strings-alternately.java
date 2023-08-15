class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res = "";
        int len1 = word1.length(), len2= word2.length();
        if (len1 == 0) {
            return word2;
        } else if (len2 == 0) {
            return word1;
        }
        if (len1 > len2) {
            for (int i = 0 ; i < len2; i++) {
                res += word1.charAt(i);
                res += word2.charAt(i);
            }
            for (int j = len2; j < len1; j++) {
                res += word1.charAt(j);
            }
        } else {
             for (int i = 0 ; i < len1; i++) {
                res += word1.charAt(i);
                res += word2.charAt(i);
            }
            for (int j = len1; j < len2; j++) {
                res += word2.charAt(j);
            }
        }
        return res;
    }
}