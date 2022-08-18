class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

//Time complexity : O(n). We only iterate through nums, so the time complexity is the number of elements in nums.
//Space complexity : O(1).
}