```
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.
```
class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        def binarysearch(nums,l,r,key):
            if r<l:
                return False
            mid = l+(r-l)//2
            if nums[mid] == key:
                return True
            if nums[mid]==nums[r]!=key:
                return binarysearch(nums,l,r-1,key)
            if nums[mid]>nums[r]:
                if key>=nums[l] and key<nums[mid]:
                    return binarysearch(nums,l,mid-1,key)
                else:
                    return binarysearch(nums,mid+1,r,key)
            else:
                if key>nums[mid] and key<=nums[r]:
                    return binarysearch(nums,mid+1,r,key)
                else:
                    return binarysearch(nums,l,mid-1,key)
        return binarysearch(nums,0,len(nums)-1,target)