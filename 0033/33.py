```
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).
```

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        def binarysearch(nums,l,r,key):
            if r<l:
                return -1
            mid = l+(r-l)//2
            if nums[mid] ==key:
                return mid
            if nums[mid]<nums[r]:
                if key>nums[mid] and key<=nums[r]:
                    return binarysearch(nums,mid+1,r,key)
                else:
                    return binarysearch(nums,l,mid-1,key)
            else:
                if key>=nums[l] and key<nums[mid]:
                    return binarysearch(nums,l,mid-1,key)
                else:
                    return binarysearch(nums,mid+1,r,key)
        return binarysearch(nums,0,len(nums)-1,target)