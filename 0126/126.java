/*
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        HashMap<String,ArrayList<String>> nexts = getNexts(wordList);
        HashMap<String,Integer> distance = getDistance(beginWord,nexts);
        List<List<String>> res = new ArrayList<>();
        LinkedList<String> solution = new LinkedList<>();
        getShortestPaths(beginWord,endWord,distance,nexts,solution,res);
        return res;   
    }
    
    public static HashMap<String,ArrayList<String>> getNexts(List<String> words){
        Set<String> dict = new HashSet<>(words);
        HashMap<String,ArrayList<String>> nexts = new HashMap<>();
        for(String word:words){
            nexts.put(word,new ArrayList<>());
        }
        for(String word:words){
            nexts.put(word,getNext(word,dict));
        }
        return nexts;
    }
    
    public static ArrayList<String> getNext(String word, Set<String> dict){
        ArrayList<String> res = new ArrayList<String>();
        char[] chr = word.toCharArray();
        for(int i=0;i<chr.length;i++){
            for(char cur='a';cur<='z';cur++){
                if(chr[i] != cur){
                    char tmp = chr[i];
                    chr[i] = cur;
                    if(dict.contains(String.valueOf(chr))){
                        res.add(String.valueOf(chr));
                    }
                    chr[i] = tmp;
                }
            }
        }
        return res;
    }
    
    public static HashMap<String,Integer> getDistance(String beginword, HashMap<String,ArrayList<String>> nexts){
        HashMap<String,Integer> distance = new HashMap<>();
        distance.put(beginword,0);
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginword);
        visited.add(beginword);
        while(!queue.isEmpty()){
            String word = queue.poll();
            for(String next:nexts.get(word)){
                if(!visited.contains(next)){
                    distance.put(next,distance.get(word)+1);
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return distance;
    }
    public static void getShortestPaths(String curr,String end, HashMap<String,Integer> distance, HashMap<String,ArrayList<String>> nexts, LinkedList<String> solution, List<List<String>> res){
        solution.add(curr);
        if(curr.equals(end)){
            res.add(new LinkedList<String>(solution));
        }else{
            for(String next:nexts.get(curr)){
                if(distance.get(next)==distance.get(curr)+1){
                    getShortestPaths(next,end,distance,nexts,solution,res);
                }
            }
        }
        solution.pollLast();
    }
}