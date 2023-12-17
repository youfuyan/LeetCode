class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }
        int res = 1;
        for (int num : nums) {
            if(!hs.contains(num - 1)) {
                int count = 1;
                while(hs.contains(num + 1)) {
                    num++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}