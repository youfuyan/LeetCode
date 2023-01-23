class Solution {
    public int reverse(int x) {
        int res = 0, preRes = 0;
        while (x != 0) {
            int pop =  x % 10;
            res = res * 10 + pop;
            
            if ((res - pop) / 10 != preRes) {
                return 0;
            }
            preRes = res;
            x /= 10;
        }
        return res;
    }
}