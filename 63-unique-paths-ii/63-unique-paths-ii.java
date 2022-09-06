class Solution {
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        memo = new int[m][n];
        
        return dp(m - 1, n - 1, obstacleGrid);
    }
    
    private int dp (int m, int n, int[][] obstacleGrid) {
        int maxM = obstacleGrid.length;
        int maxN = obstacleGrid[0].length; 
        if (m < 0 || n < 0 || m >= maxM || n >= maxN || obstacleGrid[m][n] == 1) {
            return 0;
        }
        if (memo[m][n] > 0) {
            return memo[m][n];
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        
        memo[m][n] = dp(m - 1, n, obstacleGrid) + dp(m, n - 1, obstacleGrid);
        
        return memo[m][n];
    }
}