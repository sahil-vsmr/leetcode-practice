class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        
        if (nums.length == 0) {
            if (lower == upper) {
                result.add(Integer.toString(lower));
            } else {
                result.add(lower + "->" + upper);
            }
            return result;
        }
        
        if (nums[0] > lower) {
            if (lower + 1 == nums[0]) {
                result.add(Integer.toString(lower));    
            } else {
                result.add(lower + "->" + (nums[0] - 1));
            }
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            String range = "";
            if (nums[i+1] - nums[i] == 1) {
                continue;
            } else {
                int low = nums[i] + 1;
                int high = nums[i+1] - 1;
                if (high == low) {
                    range += high;
                } else {
                    range += low + "->" + high;
                }
            }
           result.add(range);
        }
        
        if (nums[nums.length-1] + 1 < upper) {
            String range = nums[nums.length-1] + 1 + "->" + upper;
            result.add(range);
        } else if (nums[nums.length-1] + 1 == upper) {
            String range = Integer.toString(upper);
            result.add(range);
        }
        return result;
    }
}