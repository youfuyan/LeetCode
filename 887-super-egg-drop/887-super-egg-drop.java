class Solution {
    int[][] memo;
    public int superEggDrop(int k, int n) {
        
        memo = new int[k + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -666);
        }
        return dp(k, n);
    }
    
    //Define: given k eggs with n floors, min number of move is dp(k, n)
    private int dp(int k, int n) {
        //base case 
        if (k == 1) {
            return n; //scan from bot to top
        }
        if (n == 0) {
            return 0;
        }
        
        if (memo[k][n] != -666) {
            return memo[k][n];
        }
        int res = Integer.MAX_VALUE;
        // for (int i = 1; i <= n; i++) {
        //     //try at each floor
        //     res = Math.min(res, 
        //                    //two outcome: egg break or not
        //                    Math.max(dp(k, n - i), dp(k - 1, i - 1)) + 1
        //     );
        // }
        //use binary search insteat of linear search
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            //egg break or not at mid floor
            int broken = dp(k - 1, mid - 1);
            int not_broken = dp(k, n - mid);
            if (broken > not_broken) {
                hi = mid - 1;
                res = Math.min(res, broken + 1);
            } else {
                lo = mid + 1;
                res = Math.min(res, not_broken + 1);
            }
        }
        
        //save res to memo
        memo[k][n] = res;
        return memo[k][n];
        //time: O(knlogn)
        //sapce: O(kn)
    }
    
}