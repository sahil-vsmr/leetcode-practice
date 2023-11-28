class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && nums[i] == 1) {
                counter++;
                i++;
            }
            result = Math.max(result, counter);
            counter=0;
        }
        return result;
    }
}