class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        int i = 0;
        left[0] = height[0];
        
        i = 1;
        while (i < n) {
            left[i] = Math.max(left[i-1], height[i]);
            i++;
        }
        
        i = n-1;
        right[i] = height[i];
        
        i = n-1;
        right[i] = height[i];
        i--;
        while (i >= 0) {
            right[i] = Math.max(right[i+1], height[i]);
            i--;
        }
        int result = 0;
        
        i = 0;
        
        while (i < n) {
            result += Math.min(left[i], right[i]) - height[i];
            i++;
        }
        return result;
    }
}