class Solution {
    Map<Character, List<Integer>> charMap;
    int[][] memos;
    public int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        this.charMap = new HashMap<>();
        this.memos = new int[m][n];
        for (int i = 0; i < m; i++) {
            char ch = ring.charAt(i);
            charMap.putIfAbsent(ch, new LinkedList<>());
            charMap.get(ch).add(i);
        }
        
        return dp(ring, 0, key, 0);
    }
    
    private int dp(String ring, int i, String key, int j) {
        //base case
        if (j == key.length()) {
            return 0;
        }
        if (memos[i][j] != 0) {
            return memos[i][j];
        }
        int n = ring.length();
        int res = Integer.MAX_VALUE;
        
        for (int k : charMap.get(key.charAt(j))) {
            int diff = Math.abs(k - i);
            diff = Math.min(diff, n - diff);
            int subProblem = dp(ring, k, key, j + 1);
            res = Math.min(res, 1 + diff + subProblem);
        }
        memos[i][j] = res;
        return res;
    }
}