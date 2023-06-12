class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valToIdx= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (valToIdx.containsKey(res)) {
                return new int[]{valToIdx.get(res), i};
            } else {
                valToIdx.put(nums[i], i);
            }
        }
        return null;
    }
}