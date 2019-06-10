```
Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
```
class SummaryRanges:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.num = []

    def addNum(self, val: int) -> None:
        new = [val,val]
        if not self.num:
            self.num.append(new)
            return
        i=0
        while i<len(self.num):
            if self.num[i][1]<val-1:
                i+=1
                continue
            elif self.num[i][1]==val-1:
                if i+1<len(self.num) and self.num[i+1][0]==val+1:
                    self.num[i] = [self.num[i][0],self.num[i+1][1]]
                    self.num.pop(i+1)
                    return
                else:
                    self.num[i][1]=val
                    return
            elif self.num[i][1]>=val and self.num[i][0]<=val:
                return
            elif self.num[i][0]==val+1:
                self.num[i][0] =val
                return
            else:
                self.num.insert(i,new)
                return
        self.num.append(new)
                
                    

    def getIntervals(self) -> List[List[int]]:
        return self.num


# Your SummaryRanges object will be instantiated and called as such:
# obj = SummaryRanges()
# obj.addNum(val)
# param_2 = obj.getIntervals()