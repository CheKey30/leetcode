```
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

 

Example:



BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
```
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.root = root
        self.stack = []

    def next(self) -> int:
        """
        @return the next smallest number
        """
        while self.root:
            self.stack.append(self.root)
            self.root = self.root.left
        tmp = self.stack.pop()
        res = tmp.val
        self.root = tmp.right
        return res

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.stack)!=0 or self.root !=None


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()