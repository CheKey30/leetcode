# Sort algorithms
## Selection sort
```python
def selectionsort(array):
	for i in range(len(array)):
		min_idx = i
		for j in range(i+1,len(array)):
			if array[j]< array[min_idx]:
				min_idx = j
		array[min_idx],array[i] = array[i], array[min_idx]
	return array
```
time complexity O(n^2)  
space complexity O(1)  
## Bubble sort
```python
def bubblesort(array):
	n = len(array)
	for i in range(n):
		for j in range(0,n-i-1):
			if array[j]>array[j+1]:
				array[j],array[j+1] = array[j+1], array[j]
	return array
```
time complexity O(n^2)  
space complexity O(1)  
## Insert sort
```python
def insertsort(array):
	for i in range(1,len(array)):
		key = array[i]
		j = i-1
		while j>=0 and key < array[j]:
			array[j+1] = array[j]
			j-=1
		array[j+1] = key
	return array
```
time complexity O(n^2)  
space complexity O(1)  
## Merge sort
```python
def mergesort(array):
	if len(array)>1:
		mid = len(array)//2
		L = arr[:mid]
		R = arr[mid:]
		mergesort(L)
		mergesort(R)
		#merge L and R
		i=j=k=0
		while i<len(L) and j<len(R):
			if L[i]<R[j]:
				array[k] = L[i]
				i+=1
			else:
				array[k] = R[j]
				j+=1
			k+=1
		while i<len(L):
			array[k] = L[i]
			i+=1
			k+=1
		while j < len(R):
			array[k] = R[j]
			j+=1
			k+=1
def MergeSort(array):
	mergesort(array)
	return array
```
time complexity O(nlogn)  
space complexity O(n)  
## Heap sort
```python
def heapsort(array):
	
```