```
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
```
class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        start = newInterval[0]
        end = newInterval[1]
        i = 0
        res = []
        while i<len(intervals):
            if start<=intervals[i][1]:
                if end<intervals[i][0]:
                    break
                start = min(intervals[i][0],start)
                end = max(intervals[i][1],end)
            else:
                res.append(intervals[i])
            i+=1
        res.append([start,end])
        res+=intervals[i:]
        return res