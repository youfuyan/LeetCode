class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return dp(m - 1, n - 1);
    }
    
    private int dp (int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        
        if (memo[m][n] > 0) {
            return memo[m][n];
        }
        
        memo[m][n] = dp(m - 1, n) + dp(m, n - 1);
        return memo[m][n];
        
    }
}