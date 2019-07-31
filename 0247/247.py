```
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

Example:

Input:  n = 2
Output: ["11","69","88","96"]
```
class Solution:
    def findStrobogrammatic(self, n: int) -> List[str]:
        def gen(n,out):
            if n==0:
                return [""]
            if n==1:
                return ["1","0","8"]
            mid = gen(n-2,False)
            res = []
            for i in mid:
                if not out:
                    res.append("0"+i+"0")
                res.append("1"+i+"1")
                res.append("8"+i+"8")
                res.append("6"+i+"9")
                res.append("9"+i+"6")
            return res
        return gen(n,True)