class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndex = new HashMap<Integer, Integer>();
        
        int[] result = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            valueIndex.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (valueIndex.containsKey(target-nums[i]) && valueIndex.get(target-nums[i]) != i) {
                result[0] = i;
                result[1] = valueIndex.get(target-nums[i]);
            }
        }
        return result;
    }
}