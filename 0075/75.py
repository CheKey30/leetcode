```
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def quicksort(array,l,r):
	        if l<r:
		        i,j,x = l,r,array[l]
		        while i<j:
			        while i<j and array[j]>=x:
				        j-=1
			        if i<j:
				        array[i] = array[j]
				        i+=1
			        while i<j and array[i]<=x:
				        i+=1
			        if i<j:
				        array[j] = array[i]
				        j-=1
		        array[i] = x
		        quicksort(array,l,i-1)
		        quicksort(array,i+1,r)
        quicksort(nums,0,len(nums)-1)