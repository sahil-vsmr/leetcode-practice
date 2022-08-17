class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] answer = new int[s.length()];
        
        List<Integer> positions = new ArrayList<>();
        
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
        }
        return answer;
    }
}