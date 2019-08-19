/*
Given an integer n, find the closest integer (not including itself), which is a palindrome.

The 'closest' is defined as absolute difference minimized between two integers.

Example 1:
Input: "123"
Output: "121"
Note:
The input n is a positive integer represented by string, whose length will not exceed 18.
If there is a tie, return the smaller one as answer.
*/

class Solution {
    public String nearestPalindromic(String n) {
        Long num = Long.valueOf(n);
        Long raw = getRaw(n);
        Long big = raw>num?raw:getBig(raw);
        Long small = raw<num?raw:getSmall(raw);
        System.out.print(big);
        System.out.print(small);
        return String.valueOf(big-num>=num-small?small:big);
    }
    
    public static Long getRaw(String n){
        char[] chs = n.toCharArray();
        int len = chs.length;
        for(int i=0;i<len/2;i++){
            chs[len-1-i] = chs[i];
        }
        return Long.valueOf(String.valueOf(chs));
    }
    
    public static Long getBig(Long raw){
        char[] chs = String.valueOf(raw).toCharArray();
        char[] res = new char[chs.length+1];
        res[0] = '0';
        for(int i =0;i<chs.length;i++){
            res[i+1] = chs[i];
        }
        int size = chs.length;
        for(int i=(size-1)/2+1;i>=0;i--){
            if(++res[i]>'9'){
                res[i]='0';
            }else{
                break;
            }
        }
        int offset = res[0] =='1'?1:0;
        size = res.length;
        for(int i = size-1;i>=(size+offset)/2;i--){
            res[i] = res[size-i-offset];
        }
        return Long.valueOf(String.valueOf(res));
    }
    
    public static Long getSmall(Long raw){
        char[] chs = String.valueOf(raw).toCharArray();
        char[] res = new char[chs.length];
        int size = res.length;
        for(int i=0;i<size;i++){
            res[i] = chs[i];
        }
        for(int i=(size-1)/2;i>=0;i--){
            if(--res[i]<'0'){
                res[i] = '9';
            }else{
                break;
            }
        }
        if(res[0]=='0'){
            res = new char[size-1];
            for(int i=0;i<res.length;i++){
                res[i] = '9';
            }
            return size==1?0:Long.valueOf(String.valueOf(res));
        }
        for(int k=0;k<size/2;k++){
            res[size-1-k] = res[k];
        }
        return Long.valueOf(String.valueOf(res));
    }
}