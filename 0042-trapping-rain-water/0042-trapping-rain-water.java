class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        
        int left = height[0];
        int right = height[height.length-1];
        
        for (int i = 0; i < height.length; i++) {
            if (left < height[i]) {
                left = height[i];
            }
            leftMax[i] = left;
        }
        
        
        for (int i = height.length-1; i >= 0; i--) {
            if (right < height[i]) {
                right = height[i];
            }
            rightMax[i] = right;
        }
        
        int result = 0;
        
        for (int i = 0; i < height.length; i++) {
            result = result + Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return result;
    }
}