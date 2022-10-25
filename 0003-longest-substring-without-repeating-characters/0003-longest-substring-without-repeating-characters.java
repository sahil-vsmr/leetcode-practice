class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        int right = 0;
        int left = 0;
        int result = 0;
        int length = s.length();
        
        while (right < length) {
            Character r = s.charAt(right);
            map.put(r, map.getOrDefault(r, 0) + 1);
            
            while (map.get(r) > 1) {
                Character l = s.charAt(left);
                map.put(l, map.get(l)-1);
                left++;
            }
            
            result = Math.max(result, right-left+1);
            right++;
        }
        return result;
    }
}