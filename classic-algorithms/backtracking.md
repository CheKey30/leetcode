# 回溯算法

Backtracking，回溯算法，一般用于枚举类问题，比如给定x，要求找到关于x的满足条件y所有可能结果z。这样的问题都可以用回溯算法来解。总体思路为深度遍历x，先看第一层可以选择x内的哪个元素，定下来后再进行递归调用，在x剩下元素中挑选加入后仍旧满足y的，定下后再次递归调用。当到达一层后满足输出条件则在结果z中加入当前组合然后退出，或者当到达一层后发现无法再继续向下（到达了x底端或者之后的所有可能都不会满足条件y）时退回上一层，并且要把这层加入的元素退出。一般回溯算法可以分为两类，第一类是要求找到满足条件的集合，称为子集树，解没有顺序要求。第二类是找到满足条件的排列，称为排列树，解是有顺序要求的。
典型题目有：排列组合，N皇后，01背包问题等。
<!-------------more------------------->

# 排列树

排列树，就是指初始元素集x里的相对顺序重要，比如x=[1,2,3,4] 求出x的所有排列。此时[1,2,3,4]和[2,1,3,4]是两个不同的解，都需要加入结果中。因此不用顺序遍历记录index递归的方法，使用等长数组记录visited的方法来做。比如下文的排列例子。
一般写法：

```
def backtracking(s,visited,curr,res):
	if curr satisfied output condition:
		res.add(curr)
		return
	for i in range(len(s)):
		if s[i] not visited:
        	visited[i] = True
        	curr.add(s[i])
        	if curr satisfied condition y:
        		backtracking(s,visited,curr,res)
        	visited[i] = False
        	curr.pop()

```

第二种写法（只返回长度为n的排列）：

```
def backtracking(t):
	if t==n:
		output(x)
		return
	for i in range(t,n):
		swap(x[t],x[i])
		if constraint(t):
			backtracking(t+1)
		swap[x[t],x[i]]
```

排列数的时间复杂度为O(n!)

# 子集树

所谓子集树，就是指元素间的相对顺序不重要，比如组合，x=[1,2,3,4]，此时[1,2,3,4] 和[2,1,3,4] 完全一样，只需返回一个即可。此时用顺序遍历记录index递归即可，不需要记录visited。即当走到某个元素时，该元素之前的元素都不需要被访问了。问题的解的长度不是固定的，即可以从中选择0个或多个。比如下文的组合例子，N皇后例子，01背包例子。
一般写法（不回头遍历的思路）：

```
def backtracking(s,index,curr,res):
	if curr satisfied output condition:
		res.add(curr)
		return
	for i in range(index,len(s)):
		curr.add(s[i])
		if curr satisfied condition y:
			backtracking(i+1,curr,res)
		curr.pop()

```

另一种对这类问题的理解是每次对原集合中的一个元素做判断，是加入还是不加入（有的问题状态会多于两个比如n皇后）分别做二叉树的两支继续往下讨论，当走不动了就剪枝。

另一种写法：

```
def backtracking(t):
	if t==n:
		output(x)
		return
	for i in range(2): //i有两个取值0，1表示选或者不选 x[t]，灵活看待，对于n皇后则i有n个取值
		x[t]=i
		if constraint(t):
			backtracking(t+1)
```

子集树的时间复杂度是O(2^n)

# N皇后问题

问题描述：
给定一个N\*N的棋盘，要求放入N个皇后，要满足这N个皇后任意两个不同行，不同列，不同对角线，求出一共有几种放置方法。
由于N个棋子之间没有差异，因此这是个不回头的回溯问题，套用上方一般写法，加入判断条件即可。

```
def queen(index,N,curr,res):
	if index == N:
		res[0]+=1
		return
	for i in range(N):
		curr[index] = i
		if valided(index):
			queen(index+1,N,curr,res)
def valid(index):
	k=0
	while k<index:
		if curr[k]==curr[index]:
			return False
		if abs(curr[k]-curr[index])==i-k:
			return False
	return True

def nQueens(N):
    res = [0]
    curr = [0]*N
    queen(0,N,curr,res)
    return res
```

# 排列

问题描述：
给定一个列表或字符串或数列，求出其中元素可能组成的不同排列。
分两种情况，如果有重复元素，则可以用集合来存储结果达到去重的目的，如果没有，则直接用列表存储就行。

```
def permutation(s,visited,curr,res):
	if curr not in res and curr !="":
		res.add(curr)
	for i in range(len(s)):
		if not visited[i]:
			visited[i] = True
			curr+=s[i]
			permutation(s,viisted,curr,res)
			visited[i] = False
			curr = curr[:-1]
def use(s):
	visited = [False]*len(s)
	curr = ""
	res = set()
	permutation(s,visited,curr,res)
	return res
```

# 组合

问题描述：
给定一个列表或字符串或数列，要求从中取出k个元素组成集合，问可以组成多少种不同组合。
同理，如果有重复元素则用集合来保存结果。

```
def combination(s,index,k,curr,res):
	if len(curr) == k and curr not in res:
		res.add(curr)
		return
	for i in range(index,len(s)):
		curr+=s[i]
		combination(s,i+1,k,curr,res)
		cur = cur[:-1]
def use(s,k):
	res = set()
	combination(s,0,k,"",res)
	return len(res)
```

# 01背包

问题描述：

有一堆价值和重量不等的商品，一个小偷想偷走它们，但是他的背包只能承受W的重量，求如何拿商品使得收益最大。

利用子集树求解0-1背包问题，主要还是如何剪枝。即，在什么情况下会选择不搜索左子树（放弃x_i=1），在什么情况下会选择不搜索右子树（放弃x_i=0）。

当选择x_i=1，背包就会超重时，就会放弃搜索左子树；当选择x_i=0，当前背包的价值和剩余未放入物品（不包括物品i，因为已经选择不放）的价值总和都小于目前最佳价值时，说明已经预测到这个没有前景了，可以放弃继续搜索右子树了。

代码：

```
// 全局变量W：背包承重，cw：当前背包内的重量，cv：当前价值，w：各个物品重量，v：各个物品价格，m：求得的最大值，n：物品个数,x：表示每件物品状态。
def bound(i): //预估一个放入当前物品后能达到的价值上界
	rw = W-cw  // 剩余容量
	vb = cv  // 当前背包价值初始化为上一层算出的背包价值
	// 按单位价值递减放入物品
	while i<n and w[i] <=rw:
		rw -= w[i]
		vb += v[i]
		i+=1
	if i<n:
		vb+=(v[i]/w[i])*wr 
	// 如果当前不是回溯的最后一层即还没有对最后一个商品进行过判断，计算出一个之后价值的上限vb（由于物品按单位重量价值排序，后面的单位重量一定不会超过当前的，所以后面的价值一定不会超过把剩余重量全部换算为当前物品）
	return vb
def backtracking(i):
	if i==n:
		m = max(cv,m)
		return
	if cw+w[i]<=W: //左子树，放入第i个物品
		x[i]=1
		cw+=w[i]
		cv+=v[i]
		backtracking(i+1)
		x[i]=0
		cw-=w[i]
		cv-=v[i]
	if bound(i+1)>m // 右子树， 即拿出第i个后面的值仍可能超过当前的最大值m
		backtracking(i+1)
		
```

01背包是子集树问题，因此时间复杂度为O(2^n),空间复杂度为O(n)。此问题还可以动态规划来解，详见动态规划笔记。