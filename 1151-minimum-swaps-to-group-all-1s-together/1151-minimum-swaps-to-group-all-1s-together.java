class Solution {
    public int minSwaps(int[] data) {
        int ones = Arrays.stream(data).sum();
        int cnt_one = 0, max_one = 0;
        int left = 0, right = 0;
        
        while (right < data.length) {
            //updating the number of 1's by adding the new element
            cnt_one += data[right++];
            // maintain the length of the window to ones
            if (right - left > ones) {
                //updating the number of 1's by removing the oldest element
                cnt_one -= data[left++];
            }
            // record the maximum number of 1's in the window
            max_one = Math.max(cnt_one, max_one);
        }
        
        return ones - max_one;
    }
}