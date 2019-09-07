/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
*/

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int ml=0;
        int mr=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                ml++;
            }
            if(s.charAt(i)==')'){
                if(ml!=0){
                    ml--;
                }else{
                    mr++;
                }
            }
        }
        HashSet<String> res = new HashSet<>();
        String current = "";
        dfs(s,current,res,0,ml,mr,0);
        return new ArrayList<>(res);
    }
    public void dfs(String s, String current, HashSet<String> res, int i, int ml, int mr, int open){
        if(ml<0||mr<0||open<0){
            return;
        }
        if(i==s.length()){
            if(ml==0&&mr==0&&open==0){
            res.add(current);
            
        }
            return;
        }
        
        int len = current.length();
        if(s.charAt(i)=='('){
            dfs(s,current+'(',res,i+1,ml,mr,open+1);
            dfs(s,current,res,i+1,ml-1,mr,open);
        } else if(s.charAt(i)==')'){
            dfs(s,current+')',res,i+1,ml,mr,open-1);
            dfs(s,current,res,i+1,ml,mr-1,open);
        }else {
            dfs(s,current+s.charAt(i),res,i+1,ml,mr,open);
        }
        current.substring(0,len);
    }
}