class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                //keep num[0,..., slow] has no duplicates
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}