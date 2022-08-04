class Solution {
    public List<List<String>> groupAnagrams(String[] str) {
        String[] sorted = new String[str.length];
        //Hashtable<Integer, String> ht1 = new Hashtable<>();

        HashMap<String, Integer> table = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        int resultCount = 0;
        for (int i = 0; i < str.length; i++) {
            char[] array = str[i].toCharArray();
            Arrays.sort(array);
            sorted[i] = new String(array);
            
            if (table.containsKey(sorted[i])) {
                result.get(table.get(sorted[i])).add(str[i]);
            } else {
                table.put(sorted[i], resultCount);
                resultCount++;
                List<String> list = new ArrayList<>();
                list.add(str[i]);
                result.add(list);
            }
        }
        return result;
    }
}