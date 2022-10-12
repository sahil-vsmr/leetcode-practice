class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }
    
    public int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        } else if (high == low && target == arr[low]) {
            return low;
        }
        int mid = low + (high-low+1)/2;
        
        if (target > arr[mid]) {
            return binarySearch(arr, mid+1, high, target);
        } else if (target < arr[mid]) {
            return binarySearch(arr, low, mid-1, target);
        } else {
            return mid;
        }
    }
}