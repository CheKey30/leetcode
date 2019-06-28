```
Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.

 

Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]
```
class Solution:
    def commonChars(self, A: List[str]) -> List[str]:
        res =[float("inf") for _ in range(26)]
        result = []
        for i in A:
            num =[0 for _ in range(26)]
            for j in range(len(i)):
                num[ord(i[j])-97]+=1
            ##print(num)
            for k in range(26):
                res[k] = min(res[k],num[k])
        ##print(res)
        for i in range(len(res)):
            for k in range(res[i]):
                result.append(chr(97+i))
        return result