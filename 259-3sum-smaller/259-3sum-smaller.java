class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            count += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return count;
    }
    
    private int twoSumSmaller(int[] nums, int start, int target) {
        int lo = start, hi = nums.length - 1;
        int count = 0;
        while (lo < hi) {
            if (nums[lo] + nums[hi] < target) {
                count += hi - lo;
                lo++;
            } else {
                hi--;
            }
        }
        return count;
    }
}