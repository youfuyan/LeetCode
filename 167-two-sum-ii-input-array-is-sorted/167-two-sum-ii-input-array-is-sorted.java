class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0, right = n - 1;
        if (n <= 2) {return new int[]{left + 1, right + 1};};
        
        while (left < right) {
            int twoSum = numbers[left] + numbers[right];
            if (twoSum == target) {
                return new int[]{left + 1, right + 1};
            } else if (twoSum < target) {
                left++;
            } else if (twoSum > target) {
                right--;
            }
        }
        return new int[]{};
    }
}