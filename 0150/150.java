/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
*/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String x: tokens){
            if(isNumber(x)){
                stack.push(Integer.parseInt(x));
            }else{
                int a = stack.pop();
                int b = stack.pop();
                if(x.equals("/")){
                    stack.push(b/a);
                }else if(x.equals("+")){
                    stack.push(a+b);
                }else if(x.equals("-")){
                    stack.push(b-a);
                }else{
                    stack.push(a*b);
                }
            }
        }
        return stack.pop();
    }
    
    public boolean isNumber(String x){
        if(x.equals("")){
            return false;
        }
        char[] s = x.toCharArray();
        if(s[0]!='-' && !Character.isDigit(s[0])){
            return false;
        }
        if(s.length==1 && s[0] == '-'){
            return false;
        }
        for(int i=1;i<s.length;i++){
            if(!Character.isDigit(s[i])){
                return false;
            }
        }
        return true;
    }
}