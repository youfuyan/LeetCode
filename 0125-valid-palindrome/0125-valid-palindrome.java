class Solution {
    public boolean isPalindrome(String s) {
        //two points
        int i = 0, j = s.length() - 1;
        while (i < j) {
            Character start = s.charAt(i);
            Character end = s.charAt(j);
            if(!Character.isLetterOrDigit(start)) {
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }
            
            if(Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}