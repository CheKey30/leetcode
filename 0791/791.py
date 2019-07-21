```
S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input: 
S = "cba"
T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
```
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        tmp = dict()
        rest = []
        for i in range(len(S)):
            tmp[S[i]]=1
        res=list(S)
        for i in range(len(T)):
            if T[i] in tmp and tmp[T[i]] ==0:
                res.insert(res.index(T[i]),T[i])
            elif T[i] in tmp and tmp[T[i]] != 0:
                tmp[T[i]]=0
            else:
                rest.append(T[i])
        for key in tmp:
            if tmp[key] !=0:
                res.pop(res.index(key))
        return "".join(res)+"".join(rest)