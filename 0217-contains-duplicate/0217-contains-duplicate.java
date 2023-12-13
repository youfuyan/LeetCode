class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(sets.contains(nums[i])) {
                return true;
            } else {
                sets.add(nums[i]);
            }
        }
        return false;
    }
}