class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        //find max first
        //then linear go through the array to compare candies[i]+extra with max
        int gauge = 0;
        for (int candy : candies) {
            gauge = Math.max(gauge, candy);
        }
        gauge -= extraCandies;
        List<Boolean> res = new ArrayList<>(candies.length);
        for (int candy : candies) {
            res.add(candy >= gauge);
        }
        
        return res;
    }
}