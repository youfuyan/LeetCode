class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        for (int v : nums) {
            valToFreq.put(v, valToFreq.getOrDefault(v, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {return a.getValue().compareTo(b.getValue());});
        for (Map.Entry<Integer, Integer> e : valToFreq.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        int[] res = new int[k];
        for (int i = k - 1; i >=0 ; i--) {
            res[i] = pq.poll().getKey();
        }
        
        return res;
    } 
}