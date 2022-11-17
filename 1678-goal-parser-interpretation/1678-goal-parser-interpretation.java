class Solution {
    public String interpret(String command) {
        String[] cArr = command.split("");
        
        String result = "";
        int i = 0;
        
        while (i < cArr.length) {
            switch (cArr[i]) {
                case "G":
                    result += "G";
                    i++;
                    break;
                case "(":
                    i++;
                    switch(cArr[i]) {
                        case ")":
                            result += "o";
                            i++;
                            break;
                        case "a":
                            result += "al";
                            i+=3;
                            break;
                    }
                    break;
            }
            
        }
        return result;
    }
}