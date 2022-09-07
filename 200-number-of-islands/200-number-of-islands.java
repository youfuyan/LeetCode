class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        //dfs to search num of islands
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return res;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        //check boundaries
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == '0') {
            // is water already
            return;
        }
        //flood fill this island
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
    
     private void bfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        //check boundaries
        if (r < 0 || c < 0 || r >= nr || c >= nc) {
            return;
        }
        if (grid[r][c] == '0') {
            // is water already
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(r * nc + c);
        while (!q.isEmpty()) {
            int id = q.poll();
            int row = id / nc;
            int col = id % nc;
            if (row - 1 >= 0 && grid[row-1][col] == '1') {
              q.offer((row - 1) * nc + col);
              grid[row-1][col] = '0';
            }
            if (row + 1 < nr  && grid[row+1][col] == '1') {
              q.offer((row + 1) * nc + col);
              grid[row+1][col] = '0';
            }
            if (col + 1 < nc  && grid[row][col+1] == '1') {
              q.offer(row * nc + (col+1));
              grid[row][col+1] = '0';
            }
            if (col - 1 >= 0 && grid[row][col-1] == '1') {
              q.offer(row * nc + (col-1));
              grid[row][col-1] = '0';
            } 
        }
     }
}