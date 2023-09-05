class Solution {
     boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    
    void swap(char[] c, int x, int y) {
        char temp = c[x];
        c[x] = c[y];
        c[y] = temp;
    }
    
    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        char[] c = s.toCharArray();
        while (left < right) {
            if (isVowel(c[left])) {
                if(isVowel(c[right])){
                    swap(c, left, right);
                    left++;
                    right--;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        return new String(c);
    }
    
   
}