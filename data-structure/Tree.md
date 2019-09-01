# 基本知识

## 二叉树

**二叉树**：二叉树是有限个结点的集合，这个集合或者是空集，或者是由一个根结点和两株互不相交的二叉树组成，其中一株叫根的做左子树，另一棵叫做根的右子树。

**二叉树的性质**：

- 性质1：在二叉树中第 i 层的结点数最多为2^(i-1)（i ≥ 1）
- 性质2：高度为k的二叉树其结点总数最多为2^k－1（ k ≥ 1）
- 性质3：对任意的非空二叉树 T ，如果叶结点的个数为 n0，而其度为 2 的结点数为 n2，则：`n0 = n2 + 1`

**满二叉树**：深度为k且有2^k －1个结点的二叉树称为满二叉树

**完全二叉树**：深度为 k 的，有n个结点的二叉树，当且仅当其每个结点都与深度为 k 的满二叉树中编号从 1 至 n 的结点一一对应，称之为完全二叉树。（除最后一层外，每一层上的节点数均达到最大值；在最后一层上只缺少右边的若干结点）

- 性质4：具有 n 个结点的完全二叉树的深度为 log2n + 1

**注意**：

- 仅有前序和后序遍历，不能确定一个二叉树，必须有中序遍历的结果

## 堆

如果一棵完全二叉树的任意一个非终端结点的元素都不小于其左儿子结点和右儿子结点（如果有的话） 的元素，则称此完全二叉树为最大堆。

同样，如果一棵完全二叉树的任意一个非终端结点的元素都不大于其左儿子结点和右儿子结点（如果 有的话）的元素，则称此完全二叉树为最小堆。

**最大堆的根结点中的元素在整个堆中是最大的；**

**最小堆的根结点中的元素在整个堆中是最小的。**

## 哈弗曼树

- 定义：给定n个权值作为n的叶子结点，构造一棵二叉树，若带权路径长度达到最小，称这样的二叉树为最优二叉树，也称为哈夫曼树(Huffman tree)。

- 构造：

  假设有n个权值，则构造出的哈夫曼树有n个叶子结点。 n个权值分别设为 w1、w2、…、wn，则哈夫曼树的构造规则为：

  1. 将w1、w2、…，wn看成是有 n 棵树的森林(每棵树仅有一个结点)；
  2. 在森林中选出两个根结点的权值最小的树合并，作为一棵新树的左、右子树，且新树的根结点权值为其左、右子树根结点权值之和；
  3. 从森林中删除选取的两棵树，并将新树加入森林；
  4. 重复(2)、(3)步，直到森林中只剩一棵树为止，该树即为所求得的哈夫曼树。

## 二叉排序树

二叉排序树（Binary Sort Tree）又称二叉查找树（Binary Search Tree），亦称二叉搜索树。

二叉排序树或者是一棵空树，或者是具有下列性质的二叉树：

1. 若左子树不空，则左子树上所有结点的值均小于它的根结点的值；
2. 若右子树不空，则右子树上所有结点的值均大于它的根结点的值；
3. 左、右子树也分别为二叉排序树；
4. 没有键值相等的节点

二分查找的时间复杂度是O(log(n))，最坏情况下的时间复杂度是O(n)（相当于顺序查找）

## 平衡二叉树

平衡二叉树（balanced binary tree）,又称 AVL 树。它或者是一棵空树,或者是具有如下性质的二叉树：

1. 它的左子树和右子树都是平衡二叉树，
2. 左子树和右子树的深度之差的绝对值不超过1。

平衡二叉树是对二叉搜索树(又称为二叉排序树)的一种改进。二叉搜索树有一个缺点就是，树的结构是无法预料的，随意性很大，它只与节点的值和插入的顺序有关系，往往得到的是一个不平衡的二叉树。在最坏的情况下，可能得到的是一个单支二叉树，其高度和节点数相同，相当于一个单链表，对其正常的时间复杂度有O(log(n))变成了O(n)，从而丧失了二叉排序树的一些应该有的优点。

## B-树

**B-树**：B-树是一种非二叉的查找树， 除了要满足查找树的特性，还要满足以下结构特性：

一棵 m 阶的B-树：

1. 树的根或者是一片叶子(一个节点的树),或者其儿子数在 2 和 m 之间。
2. 除根外，所有的非叶子结点的孩子数在 m/2 和 m 之间。
3. 所有的叶子结点都在相同的深度。

B-树的平均深度为logm/2(N)。执行查找的平均时间为O(logm)；

## Trie 树

Trie 树，又称前缀树，字典树， 是一种有序树，用于保存关联数组，其中的键通常是字符串。与二叉查找树不同，键不是直接保存在节点中，而是由节点在树中的位置决定。一个节点的所有子孙都有相同的前缀，也就是这个节点对应的字符串，而根节点对应空字符串。一般情况下，不是所有的节点都有对应的值，只有叶子节点和部分内部节点所对应的键才有相关的值。

Trie 树查询和插入时间复杂度都是 O(n)，是一种以空间换时间的方法。当节点树较多的时候，Trie 树占用的内存会很大。

Trie 树常用于搜索提示。如当输入一个网址，可以自动搜索出可能的选择。当没有完全匹配的搜索结果，可以返回前缀最相似的可能。

# 解决树问题的一般递归思路
给定一棵树（此处以二叉树为例），要求求出某种满足条件的结果（如最大路径和）或者判断某结果是否成立（如判断是否为平衡二叉树）。
一般思路是：当前节点做根节点，要得到结果，
	1. 需要自己的左子树给自己什么。
	2. 需要自己的右子树给自己什么。
	3. 需要自己进行什么操作。
	4. 将自己需要的东西同理的求出来返回给自己的上级（自己的根节点）。
	5. 考虑边界条件，一般是节点为空时如何处理，加在函数开头做判断。
调用这个递归函数，把根节点作为输入，得到的结果就是最终的结果。

## 判断二叉树是否为平衡二叉树
lc110

思路：
每个节点需要直到自己左子树的深度，右子树的深度。如果这两个深度相差超过1，则不是平衡二叉树，如果没超过，则算出自己的深度（左右子深度大的+1），返回给自己的父节点。

```java
public class IsBalanceTree {
    boolean balance = true;
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    
    public boolean isBalance(TreeNode root){
        helper(root);
        return this.balance;
    }
    
    public int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        if (Math.abs(left-right)>1) {
            this.balance = false;
        }
        return Math.max(left,right)+1;
    }
}
```
## 找到二叉树中的最大路径和
lc 124

思路：
对于一个节点，需要左右子树给自己以左右子为一端的最大路径和。之后更新最大路径和，最大路径和有可能是当前节点值加上左右子返回的值（如果这两个值中有负的则没有加的必要），或者之前的值。之后求出以自己为开头的最大路径和返回上一级。考虑节点为空的情况，返回0即可。

```java
public class MaxPathSum {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    int res=Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root){
        helper(root);
        return this.res;
    }
    
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Math.max(0,helper(root.left));
        int right = Math.max(0,helper(root.right));
        this.res = Math.max(this.res,root.val+left+right);
        return Math.max(left,right)+root.val;
    }
}
```

## 翻转二叉树

lc226

思路：

对于每个节点，交换自己的左右子树，之后把自己返回给自己的父节点。

```java
public class ReverseBinaryTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public TreeNode reverse(TreeNode root){
        helper(root);
        return root;
    }
    
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        helper(root.left);
        helper(root.right);
    }
}
```



# 特殊树的性质运用

## 搜索二叉树

对于搜素二叉树，中序遍历的结果会是一个有序递增序列，利用这一点通过中序遍历来找到答案，不需要一般树的思考过程。

### 找到搜索二叉树中排错的两个点并更正

lc 99

思路：中序遍历二叉树，如果是正确的，后边的值一定比前边的大，反之证明前面这个值放错地方了，接着遍历，因为只有一处错误，后边一定有且仅有一个比这个错误值小的，找到后交换这两个值即可。（用三个指针分别存两个错误值和当前值的前一个）。

```java
public class RecoveryBST {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prve = null;
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode recovery(TreeNode root){
        helper(root);
        this.first.val^=this.second.val;
        this.second.val^=this.first.val;
        this.first.val^=this.second.val;
        return root;
    }

    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        if(prve != null && prve.val>root.val){
            if(first ==null){
                first = prve;
            }
            second = root;
        }
        prve = root;
        helper(root.right);
    }
}
```




# 引用

https://hit-alibaba.github.io/interview/basic/algo/Tree.html