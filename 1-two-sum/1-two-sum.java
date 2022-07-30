class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result_array[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        boolean result_acheived = false;
        for (int index_1 = 0; index_1 < nums.length; index_1 ++) {
            if(map.containsKey(target - nums[index_1])) {
                result_array[0] = index_1;
                result_array[1] = map.get(target - nums[index_1]);
            }
            else {
                map.put(nums[index_1], index_1);
            }
        }
        return result_array;
    }
}