# Sort algorithms II
In this article, I listed some specific usages of sort algorithms such as merge linked list, iterative quick sort.
## Merge linked list
### Single linked list
```python
class Node:
	def _init__(self,value):
		self.value = value
		self.next = None
        
def sortedMerge(node1,node2):
	if node1==None:
		return node2
	if node2 == None:
		return node1
	if node1.val<=node2.val:
		res = node1
		res.next = sortedMerge(node1.next,node2)
	else:
		res = node2
		res.next = sortedMerge(node1,node2.next)
	return res

def getMiddle(head):
	if head == None:
		return head
	fastptr = head.next
	slowptr = head
	# fast moves two nodes each time
	# slow only moves one node
	# when fast reaches the end+1
	# slow just moves half
	while fastptr != None:
		fastptr = fastptr.next
		if fastptr !=None:
			slowptr = slowptr.next
			fastptr = fastptr.next
	return slowptr

def mergeSort(head):
	if head == None || head.next ==None:
		return head
	mid = getMiddle(head)
	midNext = mid.next
	mid.next = None
	left = mergeSort(head)
	right = mergeSort(midNext)
	sortedlist = sortedMerge(left,right)
	return sortedlist
```
### Double linked list
```python
class Node:
	def __init__(self,value):
		self.value = value
		self.next = None
		self.prev = None
def merge(first,second):
	if first is None:
		return second
	if second is None:
		return first
	if first.value < second.value:
		first.next = merge(first.next,second)
		first.next.prev = first
		first.prev = None
		return first
	else:
		second.next = merge(first,second.next)
		second.next.prev = second
		second.prev = None
		return second
		
def split(temphead):
	fast = slow = temphead
	while True:
		if fast.next is None:
			break
		if fast.next.next is None:
			break
		fast = fast.next.next
		slow = slow.next
	temp = slow.next
	slow.next = None
	return temp

def mergeSort(temphead):
	if temphead is None:
		return temphead
	if temphead.next is None:
		return temphead
	second = split(temphead)
	temphead = mergeSort(temphead)
	second = mergeSort(second)
	return merge(temphead,second)
```
## Iterative quick sort
```python
# find the partition place of an array
def partition(array,low,high):
	#take the last value as pivot
	pivot = array[high]
	# index before the first one
	# start comparing with the first one
	i = low-1
	for j in range(low,high):
		if array[j]<pivot:
			i+=1
			temp = array[i]
			array[i] = array[j]
			array[j] = temp
	#put pivot back to right place
	temp = array[i+1]
	array[i+1] = array[high]
	array[high] = temp
	# if there is no move, return low
	return i+1

def quickSortIterative(array,l,h):
	stack = []
	stack.append(l)
	stack.append(h)
	while stack:
		h = stack.pop(-1)
		l = stack.pop(-1)
		p = partition(array,l,h)
		if p-1>l:
			stack.append(l)
			stack.append(p-1)
		if p+1<h:
			stack.append(p+1)
			stack.append(h)
```


