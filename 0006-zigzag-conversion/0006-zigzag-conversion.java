class Solution {
    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList();
        
        if (numRows == 1) {
            return s;
        }
        
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        
        int rowCount = 0;
        boolean goingDown = false;
        
        for (char c: s.toCharArray()) {
            list.get(rowCount).append(c);
            if (rowCount == 0 || rowCount == numRows -1) goingDown = !goingDown;
            rowCount += goingDown ? 1 : -1;
        }
        
        StringBuilder result = new StringBuilder();
        for (StringBuilder letters: list) {
            result.append(letters);
        }
        
        return result.toString();
        
    }
}