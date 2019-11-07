/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment 
which could only store integers within 
the 32-bit signed integer range: [−231,  231 − 1]. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

class Solution {
    public int reverse(int x) {
        boolean flag = x<0;
        if(!flag){
            x = -x;
        }
        if(x>-10){
            return flag?x:-x;
        }
        List<Integer> bits = new ArrayList<>();
        while(x!=0){
            bits.add(x%10);
            x = x/10;
        }
        int res = 0;
        int count = 0;
        while(count<bits.size()){
            if(res<Integer.MIN_VALUE/10){
                return 0;
            }
            if(res==Integer.MIN_VALUE/10 && bits.get(count)<-8){
                return 0;
            }
            
            res = res*10+bits.get(count);
            count++;
        }
        
        if(flag){
            return res;
        }
        if(res < -Integer.MAX_VALUE){
            return 0;
        }
        return -res;
    }
}