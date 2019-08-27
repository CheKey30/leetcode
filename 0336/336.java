/*
Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:

Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]
*/

class Solution {
    public static List<List<Integer>> palindromePairs(String[] words){
        HashMap<String,Integer> wordset = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            wordset.put(words[i],i);
        }
        for(int i=0;i<words.length;i++){
            res.addAll(findAll(words[i],i,wordset));
        }
        return res;
    }

    public static List<List<Integer>> findAll(String word, int index, HashMap<String, Integer> wordset){
        List<List<Integer>> res = new ArrayList<>();
        int[] rs = manacher(word);
        String reverse = reverse(word);
        Integer rest = wordset.get("");
        if(rest  !=null && rest !=index && word.equals(reverse)){
            addRecord(res,rest,index);
            addRecord(res,index,rest);
        }
        int mid = rs.length>>1;
        for(int i =1;i<mid;i++){
            if(i-rs[i]==-1){
                rest = wordset.get(reverse.substring(0,mid-i));
                if(rest != null && rest !=index){
                    addRecord(res,rest,index);
                }
            }
        }
        for(int i=mid+1;i<rs.length;i++){
            if(i+rs[i]==rs.length){
                rest=wordset.get(reverse.substring((mid<<1)-i));
                if(rest !=null && rest != index){
                    addRecord(res,index,rest);
                }
            }
        }
        return res;
    }

    public static void addRecord(List<List<Integer>> res, int left, int right){
        List<Integer> newer = new ArrayList<>();
        newer.add(left);
        newer.add(right);
        res.add(newer);
    }

    public static int[] manacher(String word){
        char[] mchs = addBlock(word);
        int[] rs = new int[mchs.length];
        int center = -1;
        int pr = -1;
        for(int i =0; i!=mchs.length;i++){
            rs[i] = pr>i?Math.min(rs[(center<<1)-i],pr-i):1;
            while (i+rs[i]<mchs.length&&i-rs[i]>-1){
                if(mchs[i+rs[i]] !=mchs[i-rs[i]]){
                    break;
                }
                rs[i]++;
            }
            if(i+rs[i]>pr){
                pr=i+rs[i];
                center=i;
            }
        }
        return rs;
    }

    public static char[] addBlock(String word){
        char[] chs = word.toCharArray();
        char[] mchs = new char[chs.length*2+1];
        int index =0;
        for(int i=0;i!=mchs.length;i++){
            mchs[i] = (i&1)==0?'#':chs[index++];
        }
        return mchs;
    }

    public static String reverse(String str){
        char[] chs = str.toCharArray();
        int l = 0;
        int r = chs.length-1;
        while (l<r){
            chs[l]^=chs[r];
            chs[r]^=chs[l];
            chs[l++]^=chs[r--];
        }
        return String.valueOf(chs);
    }
}