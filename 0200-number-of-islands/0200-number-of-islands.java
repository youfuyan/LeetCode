class Solution {
    
    public int numIslands(char[][] grid) {  
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0;j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res += 1;
                }
            dfs(grid, i, j);
            }
        }
        return res;
    }
    
    public void dfs(char[][] grid, int m, int n) {
        if (m < 0 || m >= grid.length || n >= grid[0].length || n < 0 || grid[m][n] == '0') {
            return;
        }
        grid[m][n] = '0';
        dfs(grid, m - 1, n);
        dfs(grid, m + 1, n);
        dfs(grid, m, n + 1); 
        dfs(grid, m, n - 1);
    }
}