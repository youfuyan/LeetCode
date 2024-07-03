class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valToIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (valToIdx.containsKey(diff)) {
                return new int[]{valToIdx.get(diff), i};
            } else {
                valToIdx.put(nums[i], i);
            }
        }
        return null;
    }
}