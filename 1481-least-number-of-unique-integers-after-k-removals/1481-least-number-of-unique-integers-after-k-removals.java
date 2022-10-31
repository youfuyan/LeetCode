class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        //Put nums in map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.values());
        //sort map by frequency
        //remove first k elements
        while (k > 0) {
            k -= pq.poll();
        }
        //count map size 
        return k < 0 ? pq.size() + 1 : pq.size();
    }
}