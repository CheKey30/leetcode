# Search algorithms
## Linear search
```python
def linearsearch(array,key):
	i=0
	while i<len(array) and array[i] != key:
		i+=1
	if array[i] == key:
		return i
	else:
		return -1
```
time complexity O(n)  
space complexity O(1)  

## Binary search
```python
def binarysearch(array, key):
	left =0
	right = len(array)-1
	if left >= right:
		return -1
	while left <= right:
		mid = int((right+left)/2)
		if array[mid] == key:
			return mid
		elif array[mid]<key:
			left = mid+1
		else:
			right = mid-1
	return -1
```
time complexity O(logn)  
space complexity O(1)  
## Jump search
```python
import math
def jumpsearch(array,key):
	n = len(array)
	step = math.sqrt(n)
	prev = 0
	while array[int(min(step,n)-1)]<key:
		prev = step
		step += math.sqrt(n)
		# key is larger than the last number in array
		if prev > n:
			return -1
	# got the range from prev to step
	# check one by one
	while array[int(prev)] < key:
		prev+=1
		if prev==min(step,n):
			return -1
	# found the true one
	if array[int(prev)] == key:
		return int(prev)
	# no one fits, index of prev larger than key
	return -1
		
```
time complexity O(n^0.5)  
space complexity O(1)  
## Interpolation Search
```python
def interpolationsearch(array,key):
	n = len(array)
	left =0
	right = n-1
	while left<=right and key>=array[left] and key<=array[right]:
		if left == right:
			if array[left] == key:
				return left
			return -1
		# different from binary search, pos is not the middle one
		pos = left + int(((float(right-left)/(array[right]-array[left]))*(key-array[left])))
		if array[pos] == key:
			return pos
		elif array[pos] < key:
			left =pos +1
		else:
			right=pos-1
	return -1
```
time complexity O(loglogn)  
space complexity O(1)  
## Exponential search
```python
#binary search in recursive way
def binarysearch(array,left,right,key):
	if right>=left:
		mid = left + int((right-left))/2
		if array[mid]==key
			return mid
		elif array[mid]>key:
			return binarysearch(array,left,mid-1,key)
		else:
			return binarysearch(array,mid+1,right,key)
	return -1
def exponentialsearch(array,key):
	n = len(array)
	if array[0]==key:
		return 0
	i=1
	while i<n and array[i]<key:
		i = i*2
	return binarysearch(array,int(i/2),min(i,n),key)
```
time complexity O(logn)  
space complexity O(1)  

## Ternary Search
```python
def ternarysearch(array, left, right, key):
	if right>=left:
		mid1 = left + int((right-left)/3)
		mid2 = left + int(2*(right-left)/3)
		if array[mid1]==key:
			return mid1
		if array[mid2]==key:
			return mid2
		if array[mid1]>key:
			return ternarysearch(array,left,mid1-1,key)
		if array[mid2]<key:
			return ternarysearch(array,mid2+1,right,key)
		return ternarysearch(array,mid1+1,mid2-1,key)
	return -1
```
time complexity O(2log3n)  
space complexity O(1)  
**note:** It is not better than binary search.  
**All algorithms need a sorted array except the linear search.**  