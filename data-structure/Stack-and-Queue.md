---
title: Stack and Queue
date: 2019-08-03 11:43:11
tags: algorithm
---
# Stack
Stack，栈，一种数据结构，拥有“先进后出”的特性，简单来说就是先进入栈的元素会后出栈。类似叠放的一摞盘子，放在底部的盘子是先放进来的，但要想拿到就必须先把后放入的在它上面的盘子都拿出来。
# Queue
Queue，队列，另一种数据结构，拥有“先进先出”的特性，就是先进入队列的元素先出队列。类似排队，先排入队伍中的先被服务，出队列。
<!-----------------more---------------->
# 实现
## Stack
list 实现：
```
class Stack(object):
    def __init__(object):
        self.stack = []

    def push(self, value):
        self.stack.append(value)

    def pop(self):
        if self.stack:
            self.stack.pop()
        else:
            raise LookupError('stack is empty!')

    def is_empty(self):
        return bool(self.stack)

    def top(self):
        return self.stack[-1]
```
链表实现：
用head存储栈的头尾，使操作都为O(1)
```
class Head(object):
    def __init__(self):
        self.left = None   # left存储栈底
        self.right = None  # right存储栈顶

class Node(object):
    def __init__(self, value):
        self.value = value
        self.next = None

class Stack(object):
    def __init__(self):
        #初始化节点
        self.head = Head()

    def push(self, value):
        #插入一个元素
        newnode = Node(value)
        p = self.head
        if p.right:
            #如果head节点的右边不为NOne
            #说明栈中已经有元素了
            #就执行下列的操作
            temp = p.right
            p.right = newnode
            newnode.next = temp  #队列和栈的区别，一个链表正接，一个链表反接
        else:
            #这说明队列为空，插入第一个元素
            p.right = newnode
            p.left = newnode

    def pop(self):
        #取出一个元素
        p = self.head
        if p.left and (p.left == p.right):
            #说明栈中已经有元素
            #但是这是最后一个元素
            temp = p.left
            p.left = p.right = None
            return temp.value
        elif p.left and (p.left != p.right):
            #说明栈中有元素，而且不止一个
            temp = p.right
            p.right = temp.next
            return temp.value

        else:
            #说明栈为空
            #抛出查询错误
            raise LookupError('queue is empty!')

    def is_empty(self):
        if self.head.left:
            return False
        else:
            return True

    def bottom(self):
        #查询目前栈中栈底元素
        if self.head.left:
            return self.head.left.value
        else:
            raise LookupError('queue is empty!')
```

## Queue
list实现：入队列加入队尾，出队列从头部拿取元素。
```
class Queue(object):
    def __init__(object):
        self.stack = []

    def enqueue(self, value):
        self.stack.append(value)

    def dequeue(self):
        if self.stack:
            self.stack.pop(0)
        else:
            raise LookupError('stack is empty!')

    def is_empty(self):
        return bool(self.stack)

    def top(self):
        return self.queue[0]
```
链表实现:
定义一个头结点，左边指向队列的开头，右边指向队列的末尾，这样就可以保证我们插入一个元素和取出一个元素都是O(1)的操作。

```
class Head(object):
    def __init__(self):
        self.left = None
        self.right = None

class Node(object):
    def __init__(self, value):
        self.value = value
        self.next = None

class Queue(object):
    def __init__(self):
        #初始化节点
        self.head = Head()

    def enqueue(self, value):
        #插入一个元素
        newnode = Node(value)
        p = self.head
        if p.right:
            #如果head节点的右边不为NOne
            #说明队列中已经有元素了
            #就执行下列的操作
            temp = p.right
            p.right = newnode
            temp.next = newnode
        else:
            #这说明队列为空，插入第一个元素
            p.right = newnode
            p.left = newnode

    def dequeue(self):
        #取出一个元素
        p = self.head
        if p.left and (p.left == p.right):
            #说明队列中已经有元素
            #但是这是最后一个元素
            temp = p.left
            p.left = p.right = None
            return temp.value
        elif p.left and (p.left != p.right):
            #说明队列中有元素，而且不止一个
            temp = p.left
            p.left = temp.next
            return temp.value

        else:
            #说明队列为空
            #抛出查询错误
            raise LookupError('queue is empty!')

    def is_empty(self):
        if self.head.left:
            return False
        else:
            return True

    def top(self):
        #查询目前队列中最早入队的元素
        if self.head.left:
            return self.head.left.value
        else:
            raise LookupError('queue is empty!')
```

# 常见应用
## Stack
查看括号的完整性：
给定由前后括号组成的字符串，判断这个括号串是否合法。
思路：遍历字符串，如果是左括号则入栈，右括号则出栈一个，如果最后栈为空，则合法。

## Queue

