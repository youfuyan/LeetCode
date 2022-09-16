class Solution {
    HashMap<Integer, List<int[]>> indegree;
    int src, dst;
    int[][] memo;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //change # of stops to # of edges
        k++;
        this.src = src;
        this.dst = dst;
        //init memo by a special value
        memo = new int[n][k + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -666);
        }
        
        indegree = new HashMap<>();
        for (int[] f : flights) {
            int from = f[0];
            int to = f[1];
            int price = f[2];
            //record the direction and weight
            indegree.putIfAbsent(to, new LinkedList<>());
            indegree.get(to).add(new int[]{from, price});
        }
        
        return dp(dst, k);
    }
    // start from scr, reach to s by k steps
    private int dp(int s, int k) {
        //base case
        if (s == src) {
            return 0;
        }
        
        if (k == 0) {
            return -1;
        }
        
        if (memo[s][k] != -666) {
            return memo[s][k];
        }
        
        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(s)) {
            for (int[] v : indegree.get(s)) {
                int from = v[0];
                int price = v[1];
                //min price from src to adjacent nodes
                int subProblem = dp(from, k - 1);
                //continue if no solution
                if (subProblem != -1) {
                    res = Math.min(res, subProblem + price);
                }
            }
            
        }
        //save res to memo
        memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[s][k];
    }
}