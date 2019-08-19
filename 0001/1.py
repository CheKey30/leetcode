```
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        index = [];
        for i in range(len(nums)):
            index.append([nums[i],i])
        index = sorted(index,key=lambda x:x[0])
        l,r = 0,len(index)-1
        while l<r:
            if index[l][0]+index[r][0]<target:
                l+=1
            elif index[l][0]+index[r][0]>target:
                r-=1
            else:
                return[index[l][1],index[r][1]]