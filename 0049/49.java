/*
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> dict = new HashMap<>();
        for(String s:strs){
            int[] count = new int[26];
            for(char c:s.toCharArray()){
                count[c-'a']++;
            }
            String s1 = "";
            for(int i:count){
                s1+=i;
            }
            if(dict.containsKey(s1)){
                dict.get(s1).add(s);
            }else{
                List<String> stl = new ArrayList<>();
                stl.add(s);
                dict.put(s1,stl);
            }   
        }
        
        List<List<String>> res = new ArrayList<>();
        for(List<String> list: dict.values()){
            res.add(list);
        }
        return res;
    }
}