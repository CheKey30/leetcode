/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
*/
class Solution {
    public int nthUglyNumber(int n) {
        int[] help = new int[n];
        int two = 0;
        int three = 0;
        int five = 0;
        help[0]=1;
        int min_val = 0;
        for(int i=1;i<n;i++){
            min_val = Math.min(Math.min(help[two]*2,help[three]*3),help[five]*5);
            if(help[two]*2==min_val){
                two++;
            }
            if(help[three]*3==min_val){
                three++;
            }
            if(help[five]*5==min_val){
                five++;
            }
            help[i]=min_val;
        }
        return help[n-1];
    }
}