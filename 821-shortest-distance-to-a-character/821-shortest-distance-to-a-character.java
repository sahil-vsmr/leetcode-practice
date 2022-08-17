class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] answer = new int[s.length()];
        
        /*List<Integer> positions = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                positions.add(i);   
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            int min = Integer.MAX_VALUE;
            if (s.charAt(i) == c) {
                answer[i] = 0;
                continue;
            }
            for (int position: positions) {
                min = min > Math.abs(position - i) ? Math.abs(position - i) : min;
            }
            answer[i] = min;
        }*/
        
        int[] leftTraverse = new int[s.length()];
        int[] rightTraverse = new int[s.length()];
        
        int currentPosition = -1;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                currentPosition = i;
            }
            leftTraverse[i] = currentPosition;
        }
        
        currentPosition = -1;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                currentPosition = i;
            }
            rightTraverse[i] = currentPosition;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (leftTraverse[i] == -1) {
                answer[i] = Math.abs(i - rightTraverse[i]);
            } else if (rightTraverse[i] == -1) {
                answer[i] = Math.abs(i - leftTraverse[i]);
            } else {
                answer[i] = Math.min(Math.abs(i - leftTraverse[i]), Math.abs(i - rightTraverse[i]));
            }
        }
        return answer;
    }
}