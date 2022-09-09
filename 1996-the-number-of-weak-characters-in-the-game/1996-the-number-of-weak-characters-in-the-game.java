class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;
        int count = 0;
        Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0]);
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (properties[i][1] < max) {
                count++;
                
            } 
            max = Math.max(properties[i][1], max);
        }
        
        return count;
    }
}