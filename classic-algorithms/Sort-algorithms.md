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
## Shell sort
```python
def shell_sort(array):
	gap = int(len(array)/2)
	while gap>0:
		for i in range(len(array)-gap):
			if array[i]>array[i+gap]:
				array[i],array[i+gap]=array[i+gap],array[i]
		gap = int(gap/2)
	return list
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
	n = len(array)
	#build a maxheap
	for i in range(n,-1,-1):
		heapify(array,n,i)
	# extract elements one by one
	for i in range(n-1,0,-1):
		array[i],array[0] = array[0],array[i]
		heapify(array,i,0)
def heapify(array,n,i):
	largest = i
	l = 2*i+1
	r = 2*i+2
	if l<n and array[i]<array[l]:
		largest = l
	if r<n and array[i]<array[r]:
		largest = r
	if largest != i:
		array[i],array[largest] = array[largest],array[i]
		heapify(array,n,largest)
```
for more details about [Heap](./Data-structure/Heap.md)  
time complexity O(nlogn)  
space complexity O(logn)  
## Quick sort
```python
def quicksort(array,l,r):
	if l<r:
		i,j,x = l,r,array[l]
		while i<j and array[j]>=x:
			j+=1
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
	return array
````
time complexity O(nlogn)  
space complexity O(logn)  
## Counting sort
```python
def countsort(array):
	n = len(array)
	output = [0]*(n)
	count = [0]*(k) # numbers in array are from 0 to k
	for i in range(0,n):
		index = aray[i]
		count[index] +=1
	for i in range(1,10):
		count[i]+=count(i-1)
	i = n-1
	while i>=0:
		index = array[i]
		output[count[index]-1] = array[i]
		count[index]-=1
		i-=1
	for i in range(0,n):
		array[i] = output[i]
	return array
```
time complexity O(n+k)  
space complexity O(n)  
## Radix sort
```python
def radixsort(array):
	max_val = max(array)
	exp =1
	while max1/exp>0:
		countsortbit(array,exp)
		exp*=10
	return array
def countsortbit(array,exp):
	n = len(array)
	output = [0]*(n)
	count = [0]*(n)
	for i in range(0,n):
		index = array[i]/exp1
		count[index%10]+=1
	for i in range(1,10):
		count[i]+=count[i-1]
	i=n-1
	while i>=0:
		index = array[i]/exp
		output[count[index%10]-1] = array[i]
		count[index%10]-=1
		i-=1
	i=0
	for i in range(0,n):
		array[i] = output[i]
```
time complexity O((n+b)\*logb(k)) (k is the max number, b is the decimal system)  
space complexity O(n)  
## bucket sort
```python
# used for uniformly distributed values over a range. 
def bucketsort(array):
	arr = []
	slot_num = 10 # divide the range into 10 slots
	for i in range(slot_num):
		arr.append([])
	for j in array:
		index = int(slot_num*j)
		arr[index].append(j)
	for j in range(slot_num):
		arr[i] = insertionSort(arr[i])
	k = 0
	for i in range(slot_num):
		for j in range(len(arr[i])):
			array[k] = arr[i][j]
			k+=1
	return array
```
time complexity O(n)  
space complexity O(n)  
