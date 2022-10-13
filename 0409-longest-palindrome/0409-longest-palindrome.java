class Solution {
    public int longestPalindrome(String s) {
        char[] letters = s.toCharArray();
        
        Map<Character, Integer> letterCount = new HashMap<>();
        
        for (Character c: letters) {
            int count = letterCount.getOrDefault(c, 0);
            letterCount.put(c, ++count);
        }
        
        boolean containsOdd = false;
        int result = 0;
        
        for (Character c: letterCount.keySet()) {
            while (letterCount.get(c) > 1) {
                result += 2;
                int count = letterCount.get(c) - 2;
                letterCount.put(c, count);
            }
            
            if (letterCount.get(c) == 1) {
                containsOdd = true;
            }
        }
        
        if (containsOdd) {
            result += 1;
        }
        
        return result;
    }
}