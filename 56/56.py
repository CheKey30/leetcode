```
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
```
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals = sorted(intervals,key=lambda x:x[0])
        if not intervals:
            return intervals
        
        res = [intervals.pop(0)]
        for i in intervals:
            if res[-1][1]>=i[0]:
                tmp = res.pop(-1)
                l = min(tmp[0],i[0])
                r = max(tmp[1],i[1])
                res.append([l,r])
            else:
                res.append(i)
        return res