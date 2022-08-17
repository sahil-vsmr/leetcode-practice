class Solution {
    public int numUniqueEmails(String[] emails) {
        List<String> resultEmailIds = new ArrayList<>();
        for (int i = 0; i < emails.length; i++) {
            String[] splitString = emails[i].split("@");
            String localName = "";
            String s = splitString[0];
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '.') {
                    continue;
                } else if (s.charAt(j) == '+') {
                    break;
                } else {
                    localName += Character.toString(s.charAt(j));
                }
            }
            if (!resultEmailIds.contains(localName+"@"+splitString[1])) {
                resultEmailIds.add(localName+"@"+splitString[1]);
            }
        }
        return resultEmailIds.size();
    }
}