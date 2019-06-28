```
Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.

Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.

 

Example 1:

Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
Output: [[1,87],[2,88]]
Explanation: 
The average of the student with id = 1 is 87.
The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
```
class Solution:
    def highFive(self, items: List[List[int]]) -> List[List[int]]:
        score = dict()
        res =[]
        for i in items:
            if i[0] in score:
                score[i[0]].append(i[1])
            else:
                score[i[0]] = [i[1]]
        for key in score:
            tmp = sorted(score[key], reverse=True)
            ##print(tmp)
            if len(tmp)<5:
                res.append([key,int(sum(tmp)/len(tmp))])
            else:
                res.append([key,int(sum(tmp[:5])/5)])
        return res