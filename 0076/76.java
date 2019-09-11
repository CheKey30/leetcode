/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/

class Solution {
    public static String minWindow(String s, String t) {
        int len = t.length();
        int match =0;
        int min= Integer.MAX_VALUE;
        String res = "";
        int l = 0;
        int r = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        while(r<s.length()){
            if(map.containsKey(s.charAt(r))){
                map.put(s.charAt(r),map.get(s.charAt(r))-1);
                if(map.get(s.charAt(r))>=0){
                    match++;
                }

            }
            while(match==len){
                if(min>(r-l+1)){
                    min = r-l+1;
                    res = s.substring(l,r+1);
                }
                if(map.containsKey(s.charAt(l))){
                    map.put(s.charAt(l),map.get(s.charAt(l))+1);
                    if(map.get(s.charAt(l))>0){
                        match--;
                    }
                }
                l++;
            }
            r++;
        }
        return res;
    }
}