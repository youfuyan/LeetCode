class Solution {
    private int[] memos;
    public int rob(int[] nums) {
        int n = nums.length;
        memos = new int[n];
        Arrays.fill(memos, -1);
        return dp(nums, 0);
    }
    
    private int dp(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memos[i] != -1) {
            return memos[i];
        }
        memos[i] = Math.max(dp(nums, i + 1), dp(nums, i + 2) + nums[i]);
        
        return memos[i];
    }
}