class Solution {
    LinkedList<Integer> res = new LinkedList<>();
    
    public List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return res;
    }
    
    private void sort(int[] arr, int n) {
        //base case 
        if (n == 1) {
            return;
        }
        //find index of max pancake
        int maxCake  = 0;
        int maxCakeIdx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxCake) {
                maxCakeIdx = i;
                maxCake = arr[i];
            }
        }
        //first flip, get max to top
        reverse(arr, 0, maxCakeIdx);
        res.add(maxCakeIdx + 1);
        //second flip
        reverse(arr, 0, n - 1);
        res.add(n);
        //recursion
        sort(arr, n - 1);
    }
    
    
    
    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }
}