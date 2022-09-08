class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        
        // build hashmap : character and how often it appears
        // O(N) time
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count. put(n, count.getOrDefault(n, 0) + 1);
        }
        // init heap with less frequent element first
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
        
        // keep k top frequent elements in the heap
        for (int n : count.keySet()) {
            pq.add(n);
            if (pq.size() > k) {
                 pq.poll();
            }
               
        }
        // build an output array
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            top[i] = pq.poll();
        }
        return top;
    }
}