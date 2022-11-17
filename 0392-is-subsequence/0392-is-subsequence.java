class Solution {
    public boolean isSubsequence(String s, String t) {
        
        if (s.isEmpty()) {
            return true;
        }
        String[] sArr = s.split("");
        int index = 0;
        for (String letter: sArr) {
            boolean found = false;
            while (index < t.length()) {
                if (Character.toString(t.charAt(index)).equals(letter)) {           
                    index ++;
                    found = true;
                    break;   
                }
                index++;
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}