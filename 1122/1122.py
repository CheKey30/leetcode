```
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

 

Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
```
class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        tmp = set(arr2)
        first = set(arr2)
        rest = []
        for i in arr1:
            if i in tmp and i not in first:
                arr2.insert(arr2.index(i),i)
            elif i in tmp and i in first:
                first.remove(i)
            else:
                rest.append(i)
        rest.sort()
        return arr2+rest
            