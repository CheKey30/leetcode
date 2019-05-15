```
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.
```
class Solution:
    def findMin(self, nums: List[int]) -> int:
        min_val = float("inf")
        l,r = 0,len(nums)-1
        while l<=r:
            mid = (l+r)//2
            if nums[mid]==nums[r]:
                if min_val>nums[mid]:
                    min_val = nums[mid]
                r-=1
            elif nums[mid]>nums[r]:
                if nums[l]<min_val:
                    min_val = nums[l]
                l = mid+1
            else:
                if nums[mid]<min_val:
                    min_val = nums[mid]
                r = mid-1
        return min_val