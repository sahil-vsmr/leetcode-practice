class Solution {
    public boolean isValid(String s1) {
        Stack<Character> s = new Stack();
        
        int i = 0;
        
        while (i < s1.length()) {
            switch (s1.charAt(i)) {
                case '{':
                    s.push('{');
                    break;
                case '[':
                    s.push('[');
                    break;
                case '(':
                    s.push('(');
                    break;
                case '}':
                    if (!s.empty() && s.peek() == '{') {
                        s.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (!s.empty() && s.peek() == '[') {
                        s.pop();
                    } else {
                        return false;
                    }
                    break;
                case ')':
                    if (!s.empty() && s.peek() == '(') {
                        s.pop();
                    } else {
                        return false;
                    }
                    break;      
            }
            i++;
        }
        
        if (!s.empty()) {
            return false;
        }
        return true;
    }
}