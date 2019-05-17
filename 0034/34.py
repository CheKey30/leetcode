```
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].
```
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def lowerbound(nums,key):
            l,r=0,len(nums)
            while l<r:
                mid = l+(r-l)//2
                if nums[mid]<key:
                    l=mid+1
                else:
                    r=mid
            return l
        def higherbound(nums,key):
            l,r = 0,len(nums)
            while l<r:
                mid = l+(r-l)//2
                if nums[mid]<=key:
                    l=mid+1
                else:
                    r=mid
            return l
        l = lowerbound(nums,target)
        r = higherbound(nums,target)
        if l==r:
            return [-1,-1]
        else:
            return [l,r-1]