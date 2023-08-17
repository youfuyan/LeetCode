class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        //find max first
        //linear go through the array to compare candies[i]+extra with max
        int max = candies[0];
        int n = candies.length;
        for (int i = 1; i < n; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        List<Boolean> res = new ArrayList<Boolean>(Arrays.asList(new Boolean[n]));
        for (int j = 0; j < n; j++) {
            res.set(j, (candies[j] + extraCandies >= max));
        }
        
        return res;
    }
}