class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length(), n2 =t.length();
        if (n1 != n2) {
            return false;
        }
        HashMap<Character, Integer> charToVal = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            charToVal.put(s.charAt(i), charToVal.getOrDefault(s.charAt(i), 0) + 1);
            charToVal.put(t.charAt(i), charToVal.getOrDefault(t.charAt(i), 0) - 1);
        }
        
        for (Character k : charToVal.keySet()) {
            if(charToVal.get(k) != 0) {
                return false;
            }
        }
        return true;
    }
}