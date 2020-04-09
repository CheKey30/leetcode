/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        StringBuilder finalS = new StringBuilder();
        StringBuilder finalT = new StringBuilder();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='#' && !s.empty()){
                s.pop();
            }else if(S.charAt(i)!= '#'){
                s.push(S.charAt(i));
            }
        }
        for(int i=0;i<T.length();i++){
            if(T.charAt(i)=='#' && !t.empty()){
                t.pop();
            }else if(T.charAt(i) != '#'){
                t.push(T.charAt(i));
            }
        }
        while(!s.empty() || !t.empty()){
            if(!s.empty()){
                finalS.append(s.pop());
            }
            if(!t.empty()){
                finalT.append(t.pop());
            }
        }
        return finalS.toString().equals(finalT.toString());
    }
}