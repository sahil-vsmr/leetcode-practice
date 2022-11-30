class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        int n = s.length();
        if (n < 3) return n;
        
        int left = 0; 
        int right = 0;
        
        Map<Character, Integer> lastPos = new HashMap<Character, Integer>();
        int result = 2;
        
        while (right < n) {
            lastPos.put(s.charAt(right), right++);

            if (lastPos.size() == 3) {
                int del = Collections.min(lastPos.values());
                lastPos.remove(s.charAt(del));
                left = del + 1;
            }
            result = Math.max(result, right - left);
            
        }
        return result;
    }
}