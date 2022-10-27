class Solution {
    List<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
    public int evalRPN(String[] tokens) {
        int result = 0;
        
        Stack<Integer> stack = new Stack();
        
        for (int i = 0; i < tokens.length; i++) {
            int num1 = 0;
            int num2 = 0;
            switch(tokens[i]) {
                case "+":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 + num2);
                    break;
                case "-":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 - num2);
                    break;
                case "*":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 * num2);
                    break;
                case "/":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 / num2);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return stack.pop();
    }
}