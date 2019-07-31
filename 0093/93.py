```
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
```
class Solution(object):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        def isValid(s):
            if not s or len(s)>3:
                return False
            if s[0]=='0' and len(s)!=1:
                return False
            if len(s)==3 and int(s)>255:
                return False
            return True
        
        def findIP(s,index,ipNum,ipCom):
            if len(ipNum)==4:
                if index == len(s):
                    ipAddr = ipNum[0]
                    for i in range(1,4):
                        ipAddr+=("."+ipNum[i])
                    ipCom.append(ipAddr)
                return
            curNum = ""
            for i in range(index,len(s)):
                if i>=index+3:
                    break
                curNum+=s[i]
                if isValid(curNum):
                    ipNum.append(curNum)
                    findIP(s,i+1,ipNum,ipCom)
                    ipNum.pop(-1)
                    
        ipNum = []
        ipCom = []
        findIP(s,0,ipNum,ipCom)
        return ipCom