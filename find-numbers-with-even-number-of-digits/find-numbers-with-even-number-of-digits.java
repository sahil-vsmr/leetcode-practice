class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num: nums) {
            int counter = 0;
            while (num != 0) {
                counter++;
                num /= 10;
            }
            
            if (counter % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}