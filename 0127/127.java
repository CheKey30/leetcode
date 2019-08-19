/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        def getNext(word,wordset):
            res = []
            char = list(word)
            for i in range(len(char)):
                for j in range(97,123):
                    tmp = char[i]
                    if char[i] != chr(j):
                        char[i] = chr(j)
                        word = "".join(char)
                        if word in wordset:
                            res.append(word)
                        char[i] = tmp
            return res
        
        def getNexts(words):
            wordset = set(wordList)
            # print(wordset)
            nexts = dict()
            for i in words:
                nexts[i] = []
            for i in words:
                nexts[i] = getNext(i,wordset)
            return nexts
        
        queue = []
        visited = set()
        queue.append(beginWord)
        visited.add(beginWord)
        wordList.append(beginWord)
        nexts = getNexts(wordList)
        distance = dict()
        distance[beginWord] = 1
        # print(nexts)
        while queue:
            curr = queue.pop(0)
            # print(curr)
            for i in nexts[curr]:
                if i==endWord:
                    return distance[curr]+1
                if i not in visited:
                    visited.add(i)
                    distance[i] = distance[curr]+1
                    queue.append(i)
        return 0
                    
        