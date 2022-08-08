class Solution {
    public boolean isPalindrome(String s) {
        //tack<Character> s = new Stack();
        String lowerCase = s.toLowerCase();
        String finalString = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(lowerCase.charAt(i)) || Character.isDigit(lowerCase.charAt(i))) {
                finalString+=lowerCase.charAt(i);
            }
        }
        //System.out.println(finalString);
        
        int left = 0;
        int right = 0;
        
        if (finalString.length() % 2 == 1) {
            left = finalString.length() / 2 - 1;
            right = finalString.length() / 2 + 1;
        } else {
            left = finalString.length() / 2 - 1;
            right = finalString.length() / 2;
        }
        
        while (left >= 0 && right < finalString.length()) {
            if (finalString.charAt(left) != finalString.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        
        if (left != -1 || right != finalString.length()) {
            return false;
        }
        
        return true;
    }
}