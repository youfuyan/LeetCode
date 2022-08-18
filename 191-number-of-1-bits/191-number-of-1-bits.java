public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // treat n as an unsigned value
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}