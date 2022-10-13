class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] magChar = magazine.toCharArray();
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        
        for (Character c: magChar) {
            int count = m.getOrDefault(c, 0);
            m.put(c, ++count);
        }
        
        char[] r = ransomNote.toCharArray();
        
        for (Character c: r) {
            if (m.containsKey(c) && m.get(c) > 0) {
                int count = m.get(c);
                m.put(c, --count);
            } else {
                return false;
            }
        }
        return true;
    }
}