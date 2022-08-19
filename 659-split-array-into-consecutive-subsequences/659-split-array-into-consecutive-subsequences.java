class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> need = new HashMap<>();
        
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums) {
            //num already used in other subsequence
            if (freq.get(num) == 0) {
                continue;
            }
            //check is num can be append to a subsequence
            if (need.containsKey(num) && need.get(num) > 0) {
                //num can be append, need for num minus 1
                need.put(num, need.get(num)- 1);
                freq.put(num, freq.get(num)- 1);
                //need for (num + 1) plus 1
                need.put(num + 1, need.getOrDefault(num + 1, 0) + 1);
            } else if (freq.containsKey(num) && freq.containsKey(num + 1) && freq.containsKey(num + 2)
                && freq.get(num) > 0 && freq.get(num + 1) > 0 && freq.get(num + 2) > 0) {
                //begin a new subsequence with num as head: [num, num + 1, num + 2]
                freq.put(num, freq.get(num) - 1);
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);
                // need for (num + 3) plus 1
                need.put(num + 3, need.getOrDefault(num + 3, 0) + 1);
            } else {
                //num does not follow above two conditions, fail to append
                return false;
            }
        }
        
        return true;
    }
 
}