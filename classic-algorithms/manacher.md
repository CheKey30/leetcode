# Manacher: 求最长回文子串
该算法用于求最长回文字串，可在O(n)内求出一个字符串的最长回文字串，暴力做法需要O(n^2)的时间。主要运用动态规划的思想，之前求过的信息（以某个位置为对称中心的最长回文半径）在之后可以被反复运用，无需再求一次。
# 具体做法：
1. 先将字符串预处理，取消奇偶字符串的差异，具体做法是在当前字符串的每个字符间隔内插入一个不会出现在字符串中的符号，比如#。
2. 构造一个和字符串等长的数组dp，dp\[i]表示以i为对称轴的最长回文的回文半径。最终结果就是dp中最大值-1。
3. 同时维护一个maxright和idx，分别表示当前探查到的形成回文的最右边的位置maxright和以该位置结尾的回文的中心idx。
4. 遍历数组，当到达i位置时，i位置肯定在idx右边。有两种情况 (1) i位置超过了maxright，则当前保存的已知信息已经没用了，直接以i为中心左右比对去找到最大的回文，之后更新maxright和idx。(2) i没有超过maxright，则找到和i关于idx对称的位置j，j=2\*idx-i。可以直接读取出dp\[j]。又分两种情况，(a) j做对称轴的最长回文半径大于i到maxright的距离，此时只能确定i到maxright的部分是回文的，因此从maxright+1位置开始，以i为中心左右比对。（b）j做对称轴的最长回文半径小于等于i到maxright的距离，此时i至少也用于同样的半径，因此从这个半径的下一位开始探查。结束后更新maxright和idx。
5. 遍历结束，找到dp中的最大值，由于字符串经过了处理，这里的最大半径-1刚好就是原串的最长回文。

# 实现代码

python:

```python
 def longestPalindrome(s):
        s = "#"+"#".join(s)+"#"
        dp = [0]*len(s)
        maxRight = 0
        idx =0
        res = 0
        for i in range(len(s)):
            if i<maxRight:
                dp[i] = min(dp[2*idx-i],maxRight-i)
            else:
                dp[i]=1
            while i-dp[i]>=0 and i+dp[i]<len(s) and s[i-dp[i]]==s[i+dp[i]]:
                dp[i]+=1
            if dp[i]+i-1>maxRight:
                maxRight=dp[i]+i-1
                idx = i
            res = max(res,dp[i])
        return res-1
```

java:

```java
public static int longestPalindrome(String s){
    char[] tmp = s.toCharArray();
    char[] arr = new char[tmp.length*2+1];
    arr[0] = "#";
    int j =1;
    for(int i=0;i<tmp.length;i++){
        arr[j++]=tmp[i];
        arr[j++]="#";
    }
    int res = 0;
    char[] dp = new char[arr.length];
    int maxright =0;
    int idx = 0;
    for(int i=0;i<arr.length;i++){
        if (i<maxright){
            dp[i] = min(dp[2*idx-i],maxright-i);
        }else{
            dp[i]=1;
        }
        while(i-dp[i]>=0 && i+dp[i]<arr.length && arr[i-dp[i]] == arr[i+dp[i]]){
            dp[i]++;
        }
        if(dp[i]+i>maxright){
            maxright = dp[i]+i-1;
            idx = i;
        }
        res = Math.max(res,dp[i])
    }
    return res-1;
}
```

# 变种

1. 有时候要求求出具体的最长子回文是什么，此时结果不再记录数子，而是记录最长的对称轴和半径idx和r，则在变换字符串中idx-r+1到idx+r-1之间就是最长回文字串，取到，去标记#即可。

2. 有时候不需要连续，只要是子集（子序列）即可，则转化为一道动态规划的问题，不用这个算法解。

# 引用

1. https://segmentfault.com/a/1190000003914228#articleHeader3