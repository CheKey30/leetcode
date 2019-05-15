```
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
```
class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        def binarysearch(array,target):
            l,r = 0, len(array)-1
            while l<=r:
                mid = (l+r)//2
                if array[mid]==target:
                    return True
                elif array[mid]<target:
                    l = mid+1
                else:
                    r = mid -1
            return False
        for i in range(len(matrix)):
            if binarysearch(matrix[i],target):
                return True
        return False