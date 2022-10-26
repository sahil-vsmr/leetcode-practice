class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            int searchIndex = search(numbers, 0, numbers.length-1, complement);
            if (searchIndex != -1 && searchIndex != i) {
                
                result[0] = Math.min(i+1, searchIndex+1);
                result[1] = Math.max(i+1, searchIndex+1);
                return result;
            }
        }
        return null;
    }
    
    public int search(int[] arr, int low, int high, int target) {
        if (low <= high) {
            int mid = low + (high - low)/2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                return search(arr, low, mid-1, target);
            } else {
                return search(arr, mid+1, high, target);
            }    
        } else {
            return -1;
        }
    }
}