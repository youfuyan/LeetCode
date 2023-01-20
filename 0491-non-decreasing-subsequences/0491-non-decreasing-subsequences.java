class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        backtrack(nums, 0);
        return res;
    }
    
    List<List<Integer>> res = new LinkedList<>();
    //track path
    LinkedList<Integer> track = new LinkedList<>();
    
    //backtrack function 
    void backtrack(int[] nums, int start) {
        if (track.size() >= 2) {
            //find a valid answer
            res.add(new LinkedList<>(track));
        }
        //HashSet to avoid duplicate
        HashSet<Integer> used = new HashSet<>();
        //backtrack 
        for (int i = start; i < nums.length; i++) {
            //make sure ascending order 
            if (!track.isEmpty() && track.getLast() > nums[i]) {
                continue;
            }
            // make sure no duplicate
            if (used.contains(nums[i])) {
                continue;
            }
            used.add(nums[i]);
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}