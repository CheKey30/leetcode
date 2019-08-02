```
Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
 

Now given N, how many beautiful arrangements can you construct?

Example 1:

Input: 2
Output: 2
Explanation: 

The first beautiful arrangement is [1, 2]:

Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:

Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
```
class Solution(object):
    def countArrangement(self, N):
        """
        :type N: int
        :rtype: int
        """
        def satisfied(i,p):
            return i%p==0 or p%i==0
        
        def backtrack(N,visited,curr):
            if len(curr)==N:
                count[0]+=1
                return
            for i in range(N):
                if not visited[i]:
                    visited[i] = True
                    curr.append(i)
                    if satisfied(i+1,len(curr)):
                        backtrack(N,visited,curr)
                    visited[i] = False
                    curr.pop()
        visited = [False]*N
        count = [0]
        curr = []
        backtrack(N,visited,curr)
        return count[0]
                    