```
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
```
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        ugly =[1]
        p2,p3,p5=0,0,0
        for i in range(n):
            ug2=ugly[p2]*2
            ug3=ugly[p3]*3
            ug5=ugly[p5]*5
            ug = min(ug2,min(ug3,ug5))
            ugly.append(ug)
            if ug2==ug:
                p2+=1
            if ug3 == ug:
                p3+=1
            if ug5==ug:
                p5+=1
        return ugly[n-1]
                