class Solution {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i-1] != nums[i]) {
                twoSum(nums, i);   
            }
        }
        return result;
    }
    
    public void twoSum(int[] nums, int index) {
        int low = index+1;
        int high = nums.length - 1;
        while (low < high) {
            int sum = nums[index] + nums[low] + nums[high];

            if (sum == 0) {
                result.add(Arrays.asList(nums[index], nums[low++], nums[high--]));
                while (low < high && nums[low] == nums[low-1]) {
                    low++;
                }
            } else if (sum < 0) {
                low++;
            } else {
                high--;
            }
        }
    }
}